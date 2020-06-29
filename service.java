##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "ServiceImpl"))
##设置回调
$!callback.setFileName($tool.append("Rest", $tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/impl"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name}Dto;
import $!{tableInfo.savePackageName}.dao.$!{tableInfo.name}Dao;
import $!{tableInfo.savePackageName}.service.Rest$!{tableInfo.name}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * $!{tableInfo.comment}($!{tableInfo.name})服务实现
 *
 * @author $!author
 * @since $!time.currTime()
 */
@Service("$!tool.firstLowerCase($!{tableInfo.name})Service")
public class Rest$!{tableName} implements Rest$!{tableInfo.name}Service {
    @Resource
    private $!{tableInfo.name}Dao $!tool.firstLowerCase($!{tableInfo.name})Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param $!pk.name 主键
     * @return 实例对象
     */
    @Override
    public $!{tableInfo.name} load($!pk.shortType $!pk.name) {
        return this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.load($!pk.name);
    }

    /**
     * 查询多条数据
     *
     * @param dto 查询条件
     * @return 对象列表
     */
    @Override
    public List<$!{tableInfo.name}> list($!{tableInfo.name}Dto dto) {
        return this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.list(dto);
    }
    
    /**
     * 查询多条数据
     *
     * @param dto 查询条件
     * @return 对象列表
     */
    @Override
    public PageInfo<$!{tableInfo.name}> page($!{tableInfo.name}Dto dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.list(dto));
    }

    /**
     * 新增数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    @Override
    public $!{tableInfo.name} save($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.save($!tool.firstLowerCase($!{tableInfo.name}));
        return $!tool.firstLowerCase($!{tableInfo.name});
    }

    /**
     * 修改数据
     *
     * @param $!tool.firstLowerCase($!{tableInfo.name}) 实例对象
     * @return 实例对象
     */
    @Override
    public $!{tableInfo.name} update($!{tableInfo.name} $!tool.firstLowerCase($!{tableInfo.name})) {
        this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.update($!tool.firstLowerCase($!{tableInfo.name}));
        return this.load($!{tool.firstLowerCase($!{tableInfo.name})}.get$!tool.firstUpperCase($pk.name)());
    }

    /**
     * 通过主键删除数据
     *
     * @param $!pk.name 主键
     * @return 是否成功
     */
    @Override
    public boolean delete($!pk.shortType $!pk.name) {
        return this.$!{tool.firstLowerCase($!{tableInfo.name})}Dao.delete($!pk.name) > 0;
    }
}
