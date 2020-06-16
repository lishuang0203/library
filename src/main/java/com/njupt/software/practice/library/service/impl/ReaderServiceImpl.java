package com.njupt.software.practice.library.service.impl;

i
import com.njupt.software.practice.library.dao.ReaderMapper;
import com.njupt.software.practice.library.pojo.Reader;
import com.njupt.software.practice.library.service.ReaderService;
import com.njupt.software.practice.library.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;


    public int checkReader(Integer reader_id) {
        return readerMapper.checkReader(reader_id);
    }


    public void addReader(Reader reader) {
        readerMapper.addReader(reader);
    }


    public Reader select(Reader rd) {
        return readerMapper.select(rd);
    }


    public PageBean<Reader> listReader(Map<String, Object> paramMap) {
        PageBean<Reader> pageBean = new PageBean<Reader>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Reader> datas = readerMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = readerMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }


    public Reader selectById(Integer id) {
        return readerMapper.selectById(id);
    }


    public void updateReader(Reader reader) {
        readerMapper.updateReader(reader);
    }


    public void delReader(Integer id) {
        readerMapper.delReader(id);
    }


    public void alterpwd(Reader reader) {
        readerMapper.alterpwd(reader);
    }

}
