package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.RequestMenuItem;
import com.hamrorestaurant.hamrorestaurant.repository.MenuItemRepository;
import com.hamrorestaurant.hamrorestaurant.util.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MenuService {
    CommonResponse saveMenuItem(RequestMenuItem menuItem);
    CommonResponse updateMenuByName(RequestMenuItem menuItem, String name);
    CommonResponse updateMenuById(RequestMenuItem menuItem, String id);

}
