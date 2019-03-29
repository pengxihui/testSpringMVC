/**
 * 查询
 */

function select(){
	var roleId = "12b34e11288be47ffd2004a5405166a5";
	$.ajax({
		async:false,
		url:"role/get",
	    data:"roleId="+roleId,
	    dataType:"json",
	    error:function(){},
	    success:function(msg){
	        if(msg != null && msg != ""){
	        	var data = msg;
	        	if(data["success"]){
	        		var roleInfo = data["data"];
	        		initRoleInfo(roleInfo);
	        	}
	        }	
	    }
	})
}

/**
 * 初始化角色列表
 * @param roleInfo
 * @returns
 */
function initRoleInfo(roleInfo){
	var str = "<tbody><tr>" 
		    + "<td>"+roleInfo.roleName+"</td>"
		    + "<td>"+roleInfo.roleState+"</td>"
		    + "<td>"+roleInfo.roleDesc+"</td>"
		    + "</tr></tbody>";
	$("#roletable").append(str);
}
