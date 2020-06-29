##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Controller"))
##设置回调
$!callback.setFileName($tool.append("Rest", $tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/web"))
##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}web;

import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.bean.$!{tableInfo.name}Dto;
import $!{tableInfo.savePackageName}.common.Constants;
import $!{tableInfo.savePackageName}.common.ResultVo;
import $!{tableInfo.savePackageName}.service.Rest$!{tableInfo.name}Service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * $!{tableInfo.comment}($!{tableInfo.name})控制层
 *
 * @author $!author
 * @since $!time.currTime()
 */
@Slf4j
@RestController
@RequestMapping("$!tool.firstLowerCase($tableInfo.name)s")
public class Rest$!{tableName} {
    
    @Resource
    private Rest$!{tableInfo.name}Service rest$!tool.firstUpperCase($tableInfo.name)Service;

    /**
     * 通过主键查询$!{tableInfo.comment}
     *
     * @param $!pk.name 主键
     * @return $!{tableInfo.comment}
     */
    @GetMapping("/{$!pk.name}")
    public ResultVo load(@PathVariable $!pk.shortType $!pk.name) {
        return ResultVo.ok(this.rest$!{tool.firstUpperCase($tableInfo.name)}Service.load($!pk.name));
    }
    
    /**
     * 查询$!{tableInfo.comment}分页列表
     *
     * @param dto 查询条件
     * @return $!{tableInfo.comment}分页
     */
    @GetMapping
    public ResultVo page(@RequestBody $!{tableInfo.name}Dto dto) {
        wrap(dto);
        return ResultVo.ok(this.rest$!{tool.firstUpperCase($tableInfo.name)}Service.page(dto));
    }
    
    private void wrap($!{tableInfo.name}Dto dto) {
        dto.setPageNum(
            dto.getPageNum() == null || dto.getPageNum() == 0 ? Constants.DEFAULT_PAGE_NUM : dto.getPageNum());
        dto.setPageSize(
            dto.getPageSize() == null || dto.getPageSize() == 0 ? Constants.DEFAULT_PAGE_SIZE : dto.getPageSize());
    }
    
    /**
     * 删除$!{tableInfo.comment}
     *
     * @param $!pk.name $!{tableInfo.comment}Id
     * @return 删除结果
     */
    @DeleteMapping("/{$!pk.name}")
    public ResultVo delete(@PathVariable $!pk.shortType $!pk.name) {
        return ResultVo.ok(this.rest$!{tool.firstUpperCase($tableInfo.name)}Service.delete($!pk.name));
    }
    
    /**
     * 创建$!{tableInfo.comment}
     *
     * @param $!{tool.firstLowerCase($tableInfo.name)} $!{tableInfo.comment}信息
     * @return $!{tableInfo.comment}
     */
    @PostMapping
    public ResultVo save(@RequestBody $!{tableInfo.name} $!{tool.firstLowerCase($tableInfo.name)}) {
        return ResultVo.ok(this.rest$!{tool.firstUpperCase($tableInfo.name)}Service.save($!{tool.firstLowerCase($tableInfo.name)}));
    }

    /**
     * 更新$!{tableInfo.comment}
     *
     * @param $!{tool.firstLowerCase($tableInfo.name)} $!{tableInfo.comment}信息
     * @return $!{tableInfo.comment}
     */
    @PutMapping
    public ResultVo update(@RequestBody $!{tableInfo.name} $!{tool.firstLowerCase($tableInfo.name)}) {
        return ResultVo.ok(this.rest$!{tool.firstUpperCase($tableInfo.name)}Service.update($!{tool.firstLowerCase($tableInfo.name)}));
    }

}
