package com.repository;


import com.domain.Imodel;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Random;
@Repository
public class taxRepository {

    private static DataSource dataSource;


    private static final String CREATE = "insert into input_table (Gender, Basic_salary, House_rent, Medica_allowance, Conveyance, Festival_Bonus, Others) values (?, ?, ?, ?, ?, ?,?)";

    public taxRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public static boolean ivalue(@Valid Imodel imodel) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);

        preparedStatement.setString(1, imodel.getGender());
        preparedStatement.setInt(2, imodel.getB_sal());
        preparedStatement.setInt(3, imodel.getH_rent());
        preparedStatement.setInt(4, imodel.getM_allowance());
        preparedStatement.setInt(5, imodel.getConveyance());
        preparedStatement.setInt(6, imodel.getF_bonus());
        preparedStatement.setInt(7, imodel.getOthers());
        return preparedStatement.execute();
    }


}
