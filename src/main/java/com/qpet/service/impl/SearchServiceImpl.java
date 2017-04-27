package com.qpet.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NRTManager;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpet.dao.PetCategoryProductInfoDao;
import com.qpet.entity.PetCategoryProductInfo;
import com.qpet.entity.Search;
import com.qpet.entity.SearchField;
import com.qpet.service.SearchService;
import com.qpet.util.LuceneContext;


/** 
 * @Desc: (全文检索)
 * @author: 张瑞
 * @date: 2016年11月26日 上午11:49:10  
 * @email:2411685663@qq.com 
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private PetCategoryProductInfoDao petCategoryProductInfoDao;
	
	/**
	 * 添加索引
	 */
	public void addArticleIndex(SearchField fields) {
		try {
			NRTManager nrtManager = LuceneContext.getInstance().getNRTManager();
			Document document = field2Doc(fields);
			nrtManager.addDocument(document);
			LuceneContext.getInstance().commitIndex();//所有的增删改操作都要把索引从内存提交到磁盘，不然不会生效！！！
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fieldToArticle(PetCategoryProductInfo petCategoryProductInfo){
		try {
			SearchField field = articleToIndexField(petCategoryProductInfo);
			addArticleIndex(field);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteIndex(String id) {
		try {
			LuceneContext.getInstance().getNRTManager().deleteDocuments(new Term("id",id));
			LuceneContext.getInstance().commitIndex();//提交索引到磁盘
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateIndex(SearchField fields) {
		try {
			NRTManager nrtManager = LuceneContext.getInstance().getNRTManager();
			Document document = field2Doc(fields);
			//根据id更新索引
			nrtManager.updateDocument(new Term("id", fields.getId()), document);
			LuceneContext.getInstance().commitIndex();//提交索引到磁盘
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Search> search(String keyword) {
		IndexSearcher searcher = LuceneContext.getInstance().getSeacher();
		List<Search> indexInfoList = new ArrayList<Search>();
		try {
			/**用MultiFieldQueryParser类实现对同一关键词的跨域搜索 
	         * */
			MultiFieldQueryParser parser = new MultiFieldQueryParser(LuceneContext.getInstance().getVersion(),
						new String[]{"title","content"}, LuceneContext.getInstance().getAnalyzer());
			Query query = parser.parse(keyword);
			//TODO
			TopDocs topDocs = searcher.search(query, 10000);//查询出的所有数据,之后在前台页面用jquery插件进行分页...
			for(ScoreDoc topDoc:topDocs.scoreDocs){
				Document document = searcher.doc(topDoc.doc);
				//把检索出来的信息存到集合
				Search index = new Search();
				String title = document.get("title");
				index.setTitle(highligher(title,query,"title"));
				index.setCreateDate(new Date(Long.parseLong(document.get("createDate"))));
				String content = "";
				for(String con:document.getValues("content")) {
					content+=con;
				}
				content = Html2Text(content);//过滤html标签
				index.setSummary(highligher(content,query,"content"));
				index.setCount(topDocs.totalHits);
				index.setArticleId(document.get("objId"));
				indexInfoList.add(index);//添加索引信息到集合中
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			LuceneContext.getInstance().releaseSeacher(searcher);
		}
		return indexInfoList;
	}
	
	public static String Html2Text(String content) {  
        String htmlStr = content;  
        String textStr = "";  
        java.util.regex.Pattern p_script;  
        java.util.regex.Matcher m_script;  
        java.util.regex.Pattern p_style;  
        java.util.regex.Matcher m_style;  
        java.util.regex.Pattern p_html;  
        java.util.regex.Matcher m_html;  

        java.util.regex.Pattern p_html1;  
        java.util.regex.Matcher m_html1;  

        try {  
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>  
                                                                                                        // }  
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>  
                                                                                                    // }  
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
            String regEx_html1 = "<[^>]+";  
            p_script = Pattern.compile(regEx_script,  
                    Pattern.CASE_INSENSITIVE);  
            m_script = p_script.matcher(htmlStr);  
            htmlStr = m_script.replaceAll(""); // 过滤script标签  

            p_style = Pattern  
                    .compile(regEx_style, Pattern.CASE_INSENSITIVE);  
            m_style = p_style.matcher(htmlStr);  
            htmlStr = m_style.replaceAll(""); // 过滤style标签  

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
            m_html = p_html.matcher(htmlStr);  
            htmlStr = m_html.replaceAll(""); // 过滤html标签  

            p_html1 = Pattern  
                    .compile(regEx_html1, Pattern.CASE_INSENSITIVE);  
            m_html1 = p_html1.matcher(htmlStr);  
            htmlStr = m_html1.replaceAll(""); // 过滤html标签  

            textStr = htmlStr;  

        } catch (Exception e) {  
            System.err.println("Html2Text: " + e.getMessage());  
        }  

        return textStr;// 返回文本字符串  
    }  

	@Override
	public void reconstructIndex() {
		try{
			LuceneContext.getInstance().getNRTManager().deleteAll();//先删除磁盘上的所有索引
			List<PetCategoryProductInfo> articles = petCategoryProductInfoDao.find();//查询出所有文章信息
			try {
				indexToArticles(articles);//重建索引
			} catch (TikaException e) {
				e.printStackTrace();
			}
			LuceneContext.getInstance().commitIndex();//提交索引到磁盘
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void indexToArticles(List<PetCategoryProductInfo> petCategoryProductInfos) throws IOException, TikaException {
		for (PetCategoryProductInfo petCategoryProductInfo : petCategoryProductInfos) {
			indexToArticle(petCategoryProductInfo);
		}
	}
	
	//Article articles
	private void indexToArticle(PetCategoryProductInfo petCategoryProductInfo) throws IOException, TikaException {
		SearchField field = articleToIndexField(petCategoryProductInfo);
		addArticleIndex(field);
	}
	
	/**
	 * 把域对象(field)转换为文档对象(Document)
	 * @param field
	 * @return
	 */
	private Document field2Doc(SearchField field) {
		Document doc = new Document();
		doc.add(new Field("id",field.getId(),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
		doc.add(new Field("title",field.getTitle(),Field.Store.YES,Field.Index.ANALYZED));
		doc.add(new Field("content",field.getContent(),Field.Store.YES,Field.Index.ANALYZED));
		doc.add(new Field("objId",field.getObjId(),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
		doc.add(new NumericField("createDate",Field.Store.YES,true).setLongValue(field.getCreateDate().getTime()));
		return doc;
	}
	
	/**
	 * 把petCategoryProductInfo对象转换为IndexField对象
	 * @param petCategoryProductInfo
	 * @return
	 * @throws TikaException 
	 * @throws IOException 
	 */
	public static SearchField articleToIndexField(PetCategoryProductInfo petCategoryProductInfo) throws IOException, TikaException{
		SearchField field = new SearchField();
		field.setId(petCategoryProductInfo.getPid().toString());
		field.setObjId(petCategoryProductInfo.getPid().toString());
		field.setTitle(petCategoryProductInfo.getPname());
		field.setCreateDate(petCategoryProductInfo.getPdate());
		field.setContent(petCategoryProductInfo.getPdesc());
		return field;
	}
	
	private String highligher(String text,Query query,String field) {
		try {
			QueryScorer scorer = new QueryScorer(query);
			Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
			Formatter formatter = new SimpleHTMLFormatter("<span style='color:red;background:#ff0;font-weight:bolder;'>", "</span>");
			Highlighter lighter = new Highlighter(formatter,scorer);
			lighter.setTextFragmenter(fragmenter);
			String ht = lighter.getBestFragment(LuceneContext.getInstance().getAnalyzer(),
					field,text);
			if(ht==null) {
				if(text.length()>=100) {
					text = text.substring(0, 100);
					text=text+"....";
				}
				return text;
			}
			else return ht.trim();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			e.printStackTrace();
		}
		return text;
	}

}