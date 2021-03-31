package com.example.Repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepositoryImpl implements MailBoxRepository {
    static List<String> listLanguage;
    static List<Integer> listPageSize;

    static {
        listLanguage = new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");

        listPageSize = new ArrayList<>();
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(20);
        listPageSize.add(25);
        listPageSize.add(100);
    }


    @Override
    public List<String> getListLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> getListPageSize() {
        return listPageSize;
    }
}
