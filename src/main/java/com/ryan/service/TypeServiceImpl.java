package com.ryan.service;

import com.ryan.NotFoundException;
import com.ryan.dao.TypeRepository;
import com.ryan.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;
    @Override
    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type getType(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);
        if(t == null){
            throw new NotFoundException("不存在該類型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }
}
