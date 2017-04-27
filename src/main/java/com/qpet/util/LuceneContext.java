package com.qpet.util;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NRTManager;
import org.apache.lucene.search.NRTManagerReopenThread;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.search.SearcherWarmer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

/** 
 * @Desc: (创建单例，把这个类存到application中去)
 * @author: 张瑞
 * @date: 2016年11月28日 上午10:45:18  
 * @email:2411685663@qq.com 
 */
public class LuceneContext {
	
	private static LuceneContext instance;
	private static IndexWriter writer;
	private static Analyzer analyzer;
	private static Version version;
	private static NRTManager nrtMgr;
	private static Directory directory;
	private static SearcherManager mgr;
	private static final String INDEX_PATH = "D:/lucene/article";//存放索引的路径//TODO
	
	private LuceneContext(){}
	
	/**
	 * 创建单例，第一次为空，之后都不为空。
	 * @return
	 */
	public static LuceneContext getInstance(){
		if (instance ==null) {
			init();
			instance = new LuceneContext();
		}
		return instance;
	}
	
	/**
	 * 初始化方法
	 */
	@SuppressWarnings("resource")
	public static void init(){
		try {
			directory = FSDirectory.open(new File(INDEX_PATH));
			version = Version.LUCENE_35;
			analyzer = new MMSegAnalyzer();
			writer = new IndexWriter(directory, new IndexWriterConfig(version, analyzer));
			nrtMgr = new NRTManager(writer, new SearcherWarmer() {
				
				@Override
				public void warm(IndexSearcher s) throws IOException {
					System.out.println("reopen index...");
				}
			});
			mgr = nrtMgr.getSearcherManager(true);
			NRTManagerReopenThread reopenThread = new NRTManagerReopenThread(nrtMgr, 0.5, 0.025);
			reopenThread.setName("NRTManager reopen thread");//设置线程名
			reopenThread.setDaemon(true);
			reopenThread.start();//打开线程
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 开启searcher
	 * @return
	 */
	public IndexSearcher getSeacher(){
		return mgr.acquire();
	}
	
	/**
	 * 释放searcher
	 * @param searcher
	 */
	public void releaseSeacher(IndexSearcher searcher){
		try {
			mgr.release(searcher);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交索引
	 */
	public void commitIndex(){
		try {
			writer.commit();
			writer.forceMerge(3);//把N个索引段强制合并为3个索引段
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public NRTManager getNRTManager() {
		return nrtMgr;
	}
	
	public Version getVersion() {
		return version;
	}
	
	public Analyzer getAnalyzer() {
		return analyzer;
	}
	
}
