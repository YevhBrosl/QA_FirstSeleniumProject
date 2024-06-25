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
        list.add(new Object[]{"Jane", "Doe", "jane-doe@gm.com.ua", "123456", "123456"});
        list.add(new Object[]{"Steve", "Black", "steve_black@gm.uk", "StevenBlack", "StevenBlack"});
        list.add(new Object[]{"Frank", "White", "frankwhite79@gm.com", "frank$", "frank$"});
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
