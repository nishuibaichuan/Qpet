/**
 * @Author:张瑞
 * @DateTime:2016-10-19
 * @Description:添加，删除，查看，授权，停/启用等操作的脚本信息
 * @Version:1.0.0
 */
/* 插件树：传入setting原型扩展方法 */
var zTreeObj = null;//
(function($) {
	$.fn.mytree = function(opts) {
		var setting = $.extend({
				view: {
					selectedMulti: false,
					dblClickExpand:true
				},
				
				async: {
					enable: true,
					type:"GET",
					//如果请求到的值是null, 应该如何提示 代表当前路径：$("#ctx")
					url: opts?(opts.url||"ajaxchannel"):"ajaxchannel"
				},
				mine: {
					listChild:1,
					srcElement:"#listChannel"
				},
				callback: {
					onAsyncSuccess: function zTreeOnAsyncSuccess()
					{
						zTreeObj.expandAll(false);
					},
				},
				
				data: {
					simpleData: {
						enable: true,
						idKey: "id",
						pIdKey: "parentid",
						rootPId: -1,
					},
					key:{
						name:"name"
					}
				}
		},opts||{});
		var _mine = setting.mine;
		zTreeObj = $.fn.zTree.init($(this), setting);
		zTreeObj.getCheckParentNodes = getCheckParentNodes;
		zTreeObj.getCheckChildNodes = getCheckChildNodes;
		if(_mine.listChild) {
			zTreeObj.setting.callback.onClick = listChild;
		}
	
		/**
		 * 回调函数
		 */
		function zTreeOnAsyncSuccess()
		{
			// tips no data TODO
			zTreeObj.expandAll(true);
		}
	
		/**
		 * 点击任意栏目，列出他的所有子栏目
		 */
		function listChild(event,treeId,treeNode){
			$(_mine.srcElement).attr("src","channel/"+treeNode.id + "_0");
		}
	
		function getCheckParentNodes(treeNode,checked) {
			var ps = new Array();
			var pn;
			while((pn=treeNode.getParentNode())) {
				if(pn.checked==checked) ps.push(pn);
				treeNode = pn;
			}
			return ps;
		}
		
		//第三个参数存储所有子节点
		function getCheckChildNodes(treeNode,checked,cs) {
			var ccs;
			if((ccs=treeNode.children)) {
				for(var i=0;i<ccs.length;i++) {
					var c = ccs[i];
					if(c.checked==checked) {
						cs.push(c);
					}
					getCheckChildNodes(c,checked,cs);
				}
			}
		}
		
		return zTreeObj;
	};
})(jQuery);
