package com.example.service;

import com.example.repository.MailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxServiceImpl implements MailBoxService {

    @Autowired
    MailBoxRepository mailBoxRepository;

    @Override
    public List<String> getListLanguage() {
        return mailBoxRepository.getListLanguage();
    }

    @Override
    public List<Integer> getListPageSize() {
        return mailBoxRepository.getListPageSize();
    }
}
