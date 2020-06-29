##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Service"))
##设置回调
$!callback.setFileName($tool.append("Rest", $tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/service"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}service;

import com.github.pagehelper.PageInfo;
import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name}Dto;
import java.util.List;

/**
 * $!{tableInfo.comment}($!{tableInfo.name})服务接口
 *
 * @author $!author
 * @since $!time.currTime()
 */
public interface Rest$!{tableName} {

    /**
     * 通过ID查询单条数据
     *
     * @param $!pk.name 主键
     * @return 实例对象
     */
    $!{tableInfo.name} load($!pk.shortType $!pk.name);

    /**
     * 查询多条数据
     *
     * @param dto 查询条件
     * @return 对象列表
     */
    List<$!{tableInfo.name}> list($!{tableInfo.name}Dto dto);

    /**
     * 查询分页数据
     *
     * @param dto 查询条件
     * @return 分页列表
     */
    PageInfo<$!{tableInfo.name}> page($!{tableInfo.name}Dto dto);
    
    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} save($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    $!{tableInfo.name} update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name}));

    /**
     * 通过主键删除数据
     *
     * @param $!pk.name 主键
     * @return 是否成功
     */
    boolean delete($!pk.shortType $!pk.name);

}
