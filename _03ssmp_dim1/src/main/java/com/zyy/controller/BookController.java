package com.zyy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zyy.controller.utils.UnifiedDataFormat;
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

    //增
    @PostMapping
    public UnifiedDataFormat save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("12"))
            throw new Exception();

        Boolean flag=service.save(book);
        return new UnifiedDataFormat(flag,null,flag?"添加成功(づ￣ 3￣)づ":"操作非法，自动刷新＞﹏＜");
    }
    //删
    @DeleteMapping("/{id}")
    public UnifiedDataFormat deleteById(@PathVariable Integer id){
        Boolean flag=service.removeById(id);
        return new UnifiedDataFormat(flag,null,flag?"删除成功(づ￣ 3￣)づ":"操作非法，自动刷新＞﹏＜");
    }
    //改
    @PutMapping
    public UnifiedDataFormat update(@RequestBody  Book book){
        Boolean flag=service.updateById(book);
        return new UnifiedDataFormat(flag,null,flag?"修改成功(づ￣ 3￣)づ":"操作非法，自动刷新＞﹏＜");
    }
    //查一个
    @GetMapping("/{id}")
    public UnifiedDataFormat getById(@PathVariable Integer id){
       Book book=service.getById(id);
       Boolean flag=(book!=null);
       return new UnifiedDataFormat(flag,book,flag?"查询单个成功(づ￣ 3￣)づ":"操作有误，自动刷新＞﹏＜");
    }

    //查所有
    @GetMapping
    public UnifiedDataFormat getAll(){
        List<Book> list = service.list();
        Boolean flag=(list!=null);
        return new UnifiedDataFormat(flag,list,flag?"查询成功(づ￣ 3￣)づ":"操作有误，自动刷新＞﹏＜");
    }

//    //分页查询
//    @GetMapping("{currentPage}/{pageSize}")
//    public UnifiedDataFormat getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page=service.getPage(currentPage,pageSize);
//
//        if (currentPage>page.getPages()){//删除非第一页上的最后一条数据出现的情况
//            page=service.getPage((int)page.getPages(),pageSize);
//
//        }
//        return new UnifiedDataFormat(true,page,"分页操作成功");
//    }

    //分页条件查询
    @GetMapping("{currentPage}/{pageSize}")
    public UnifiedDataFormat getWithCondition(@PathVariable int currentPage,@PathVariable int pageSize, Book book){
        IPage<Book> page=service.getPage(currentPage,pageSize,book);

        if (currentPage>page.getPages()){//删除非第一页上的最后一条数据出现的情况
            page=service.getPage((int)page.getPages(),pageSize,book);

        }
        return new UnifiedDataFormat(true,page,"分页操作成功");
    }




}
