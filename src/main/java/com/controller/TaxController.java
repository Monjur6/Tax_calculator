package com.controller;

import com.domain.Imodel;
import com.repository.taxRepository;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("/tax")
public class TaxController {
    private static DataSource dataSource;
    private static final String CREATE = "insert into output_table (Gender, Basic_salary, House_rent, Medical_allowance, Conveyance, Festival_Bonus, Others, Total) values (?, ?, ?, ?, ?, ?, ?,?)";


    public TaxController(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("imodel", new Imodel());


        return "Index";
    }

    @RequestMapping("/ivalue")
    public String ivalue(Model model, @ModelAttribute("imodel") Imodel imodel, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "tax/ivalue";

        }
        taxRepository.ivalue(imodel);
        int yb_sal = imodel.getB_sal()*12;
        int a = 300000;
        int yh_rent;
        if(yb_sal >= a)
        {
            yh_rent = imodel.getH_rent()*12 - yb_sal/2;
        }
        else
        {
            yh_rent = imodel.getH_rent()*12 - a/2;

        }
        int ym_al = imodel.getM_allowance()*12;
        int ycon = imodel.getConveyance()*12 - 30000;
        int yf_bonus = imodel.getF_bonus()*2;
        int yother = imodel.getOthers()*12;
        int total = yb_sal + yh_rent + ym_al + ycon + yf_bonus + yother;
       // taxRepository.cal(yb_sal, yh_rent, ym_al, ycon, yf_bonus, yother);

        int g;
        String gender = imodel.getGender();
        if(gender == "Male")
        {
            g = 300000;
        }
        else g = 350000;
        int tax = 0;
        int tax1 = 0;
        int tax2 = 0;
        int tax3 = 0;
        int tax4 = 0;
        int tax5 = 0;
        while(total > 0)
        {
            if(total <= g)
            {
                tax = 0;
            }
            else
            {
                total = total - g;
                tax = 0;
                if (total <= 100000)
                {
                    tax1 = total * (5/100);
                }
                else
                {
                    total = total - 100000;
                    tax1 = 100000 * (5/100);
                    if (total <= 300000)
                    {
                        tax2 = total * (10/100);
                    }
                    else
                    {
                        tax2 = 300000 * (10/100);
                        total = total - 300000;
                        if (total <= 400000)
                        {
                            tax3 = total * (15/100);
                        }
                        else
                        {
                            tax3 = 400000 * (15/100);
                            total = total - 400000;
                            if (total <= 500000)
                            {
                                tax4 = total * (20/100);
                            }

                            {
                                tax4 = 500000 * (20/100);
                                total = total - 500000;
                            }
                        }
                    }
                }
            }
        }

        int ytax = tax + tax1 + tax2 + tax3 + tax4 + tax5;
        int mtax = ytax/12;

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(CREATE);

        preparedStatement.setString(1, imodel.getGender());
        preparedStatement.setInt(2, yb_sal);
        preparedStatement.setInt(3, yh_rent);
        preparedStatement.setInt(4, ym_al);
        preparedStatement.setInt(5, ycon);
        preparedStatement.setInt(6, yf_bonus);
        preparedStatement.setInt(7, yother);
        preparedStatement.setInt(7, total);
        preparedStatement.setInt(5, tax);
        preparedStatement.setInt(6, tax1);
        preparedStatement.setInt(7, tax2);
        preparedStatement.setInt(7, tax3);
        preparedStatement.setInt(5, tax4);
        preparedStatement.setInt(6, tax5);
        preparedStatement.setInt(7, ytax);
        preparedStatement.setInt(7, mtax);
        preparedStatement.execute();

        return "confirmation";


    }
    }
