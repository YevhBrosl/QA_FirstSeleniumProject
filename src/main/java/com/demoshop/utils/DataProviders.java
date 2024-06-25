package com.demoshop.utils;

import com.demoshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Jane", "Doe", "janedoe@gm.com", "Jane$123", "Jane$123"});
        list.add(new Object[]{"Steve", "Black", "steveblack@gm.com", "Steve$123", "Steve$123"});
        list.add(new Object[]{"Frank", "White", "frankwhite@gm.com", "Frank$123", "Frank$123"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));

        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1])
                    .setEmail(split[2]).setPassword(split[3]).setConfirmPassword(split[4])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
