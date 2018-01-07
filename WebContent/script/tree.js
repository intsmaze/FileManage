var menu = {
	setting: {
        isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        root: {
            isRoot: true,
            nodes: []
        }
    },
	loadMenuTree:function(){
		$("#menuTree").zTree(menu.setting, privilegeDate);
		
		//使用jquery的ajax完成对数据的加载
//		$.post("deviceMenuAction_showMenu.do",{},function(privilegeDate){
//			$("#menuTree").zTree(menu.setting, privilegeDate);//privilegeDate数据一定是一个json的数组
//		});
	}
};

$().ready(function(){
	menu.loadMenuTree();
});
