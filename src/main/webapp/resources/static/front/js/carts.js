//====功能：复选框全选、取消=====//
//=====全选/取消全部商家店铺及商品=====//
function ToggleCheckAll(e) {
    var inputs = document.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox" && (inputs[i].id.indexOf("chkCItem") > 0 || inputs[i].id.indexOf("chkItem") > 0 || inputs[i].id.indexOf("chkAll") > 0 || inputs[i].id.indexOf("chkHear") > 0))
            inputs[i].checked = e.checked;
    }
}
//=====商家店铺复选框，全选、取消所有子节点中的商品=====//
function ToggleCheckSon(e) {
    //em=>dt=>dl=>div=>div  商品chkItem
    var par = e.parentNode.parentNode.parentNode.parentNode.parentNode;
    var inputs = par.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox" && inputs[i].id.indexOf("chkItem") > 0)
            inputs[i].checked = e.checked;
    }
    CHKISCHECKED(e);
}
//=====商品复选框，选中、取消父节点商家======//
function ToggleCheckSelf(e) {
    var chkCount = 0;
    var chkLenght = 0;
    //td=>tr=>tbody  商品chkItem （tbody为解析时自动生成）
    var inputs = e.parentNode.parentNode.parentNode.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox" && inputs[i].id.indexOf("chkItem") > 0) {
            chkLenght++;
            if (inputs[i].checked) {
                chkCount++;
            }
        }
    }
    //td=>tr=>table=>tbody=>div=>div  商家chkCItem （tbody为解析时自动生成，所以是6个parentNode）
    var chks = e.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.getElementsByTagName('input');
    for (var j = 0; j < chks.length; j++) {
        if (chks[j].type == "checkbox" && chks[j].id.indexOf("chkCItem") > 0) {
            chks[j].checked = (chkLenght == chkCount);
        }
    }
    CHKISCHECKED(e);
}
//====“全部”复选框是否选中处理======
function CHKISCHECKED(e) {
    var chkCount = 0;
    var chkLenght = 0;
    var inputs = document.getElementsByTagName('input');
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].type == "checkbox" && (inputs[i].id.indexOf("chkCItem") > 0 || inputs[i].id.indexOf("chkItem") > 0)) {
            chkLenght++;
            if (inputs[i].checked) {
                chkCount++;
            }
        }
    }
    for (var j = 0; j < inputs.length; j++) {
        if (inputs[j].type == "checkbox" && (inputs[j].id.indexOf("chkHear") > 0 || inputs[j].id.indexOf("chkAll") > 0)) {
            inputs[j].checked = (chkLenght == chkCount);
        }
    }
}