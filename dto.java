##引入宏定义
$!define
##使用宏定义设置包后缀
#setPackageSuffix("bean")
##设置回调
$!callback.setFileName($tool.append($tableInfo.name, "Dto", ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/bean"))
##使用全局变量实现默认包导入
$!autoImport
import java.io.Serializable;

##使用宏定义实现类注释信息
#tableComment("传参")
public class $!{tableInfo.name}Dto extends $!{tableInfo.name} implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
    
    private Integer pageSize;
    private Integer pageNum;
    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    public Integer getPageSize() {
        return this.pageSize;
    }
    
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    
    public Integer getPageNum() {
        return this.pageNum;
    }
}
