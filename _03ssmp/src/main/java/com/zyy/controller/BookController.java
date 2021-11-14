package com.zyy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyy.controller.utils.R;
import com.zyy.domain.Book;
import com.zyy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService service;


    //查询所有
    @GetMapping
    public R getAll(){
        return new R(true,service.list(),"查询所有成功");
    }

    //查询单个用户
    @GetMapping("{id}")
    public R getById(@PathVariable  Integer id){
        return new R(true,service.getById(id),"操作成功*^____^*");
    }

    //添加新用户
    @PostMapping
    public R save(@RequestBody Book book) throws Exception {

        if ((book.getName()!=null)&&(book.getName()).equals("123"))
            throw new Exception();
        Boolean flag=service.save(book);

        return new R(flag,null,flag?"添加成功*^____^*":"添加失败，刷新重试＞︿＜");
//        return new R(false);//模拟添加失败

    }

    //删除用户
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(service.removeById(id),"操作成功*^____^*");
    }

    //更新用户
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(service.updateById(book),"操作成功*^____^*");
    }

    //分页查询
//    @GetMapping("{currentPage}/{size}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int size){
//
//        IPage page=service.getPage(currentPage,size);
//        if (currentPage>page.getPages())//判断当前页码是否大于总页码，当在最后一个页面执行删除最后一条记录时会出现这种情况
//            page=service.getPage((int)page.getPages(),size);
//
//        return new R(true,page,"操作成功*^____^*");
//    }

    //根据类型匹配查询
    @GetMapping("{param1}/{param}/{fds}")
    public List<Book> getWithCondition(@PathVariable String param){
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(param!=null,Book::getType,param);
        return service.list(queryWrapper);
    }

    //根据匹配类型查询
    @GetMapping("{currentPage}/{size}")
    public R getPage(@PathVariable int currentPage, @PathVariable int size,Book book){
        IPage page=service.getPage(currentPage,size,book);
        if (currentPage>page.getPages())//判断当前页码是否大于总页码，当在最后一个页面执行删除最后一条记录时会出现这种情况
            page=service.getPage((int)page.getPages(),size,book);

        return new R(true,page,"操作成功*^____^*");
    }



}
