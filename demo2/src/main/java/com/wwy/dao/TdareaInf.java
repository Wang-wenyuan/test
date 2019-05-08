package com.wwy.dao;

import com.wwy.domain.City;
import com.wwy.domain.District;
import com.wwy.domain.Province;
import com.wwy.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class TdareaInf {
    private Connection connection;
    public List getProvince(){
        List<Province> list = new ArrayList();

        try {
            connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select *from t_d_areainfo where arealevel = '1';";
            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()){
                Province province = new Province();
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                count ++;
                province.setpId(count+"");
                province.setId(id);
                province.setName(name);
                list.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public List getCity(){
        List<City> list = new ArrayList();
        try {
            connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select *from t_d_areainfo where arealevel = '2';";
            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()){
                City city = new City();
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String parentId = resultSet.getString("parent_id");
                count ++;
                city.setId(count+"");
                city.setCityId(id);
                city.setProvinceId(parentId);
                city.setName(name);
                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List getDistrict(){
        List<District> list = new ArrayList();
        try {
            connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT a.name AS city_name,a.id AS city_id,b.name district_name, b.id AS district_id,a.parent_id FROM (SELECT *FROM t_d_areainfo WHERE arealevel = '2') a LEFT JOIN (SELECT *FROM t_d_areainfo WHERE arealevel = '3') b ON a.id = b.parent_id;";
            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            while (resultSet.next()){
                District district = new District();
                String cityName = resultSet.getString("city_name");
                String cityId = resultSet.getString("city_id");
                String districtName = resultSet.getString("district_name");
                String districtId = resultSet.getString("district_id");
                String parentId = resultSet.getString("parent_id");
                count ++;
                district.setId(count+"");
                district.setCityIdId(cityId);
                district.setCityName(cityName);
                district.setDistrictId(districtId);
                district.setDistrictName(districtName);
                district.setProvinceNo(parentId);
                list.add(district);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
