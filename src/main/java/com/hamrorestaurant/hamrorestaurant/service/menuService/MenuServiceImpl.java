package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import com.hamrorestaurant.hamrorestaurant.model.menu.RequestMenuItem;
import com.hamrorestaurant.hamrorestaurant.repository.MenuItemRepository;
import com.hamrorestaurant.hamrorestaurant.util.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {
    protected static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public CommonResponse saveMenuItem(RequestMenuItem menuItem) {
        CommonResponse response = new CommonResponse();
        MenuItemPrice items = null;
        if(!ObjectUtils.isEmpty(menuItem) && !StringUtils.isEmpty(menuItem.getItemName())){
            items= menuRepo.findByItemName(menuItem.getItemName());
           if(ObjectUtils.isEmpty(items)){
               items.setMenuItem(menuItem.getMenuName());
               items.setItemName(menuItem.getItemName());
               items.setPrice(menuItem.getPrice());
               items.setCategory(menuItem.getCategory());
               items.setDescription(menuItem.getItemDescription());
               menuRepo.save(items);

               response.setData("Data has been saved !!");
               return response;
           }else{
               List<Object> errorList = new
                       ArrayList<>();
               errorList.add("Unable to save records, some problem occured while saving in DB ");
               response.setError(errorList);
           }
        }else{
            List<Object> errorList = new
                    ArrayList<>();
            errorList.add("Item already available !!!");
            response.setError(errorList);
        }
        return response;
    }

    public CommonResponse updateMenuByName(RequestMenuItem menuItem, String name){
        CommonResponse response = new CommonResponse();
        MenuItemPrice menuItemPrice= new MenuItemPrice();
        if(!ObjectUtils.isEmpty(menuItem) && !StringUtils.isEmpty(menuItem.getItemName())&& !StringUtils.isEmpty(name)){
            MenuItemPrice menu = menuRepo.findByItemName(name);
            if(!ObjectUtils.isEmpty(menu)){
                menuItemPrice.setId(menu.getId());
                menuItemPrice.setItemName(menuItem.getItemName());
                menuItemPrice.setMenuItem(menuItem.getMenuName());
                menuItemPrice.setPrice(menuItem.getPrice());
                menuItemPrice.setCategory(menuItem.getCategory());
                //saving menu item object
                menuRepo.save(menuItemPrice);
                response.setData("Record has been saved!!!");
            }else{
                List<Object> errorList = new ArrayList<>();
                errorList.add("Item not available!!!");
                response.setError(errorList);
            }
        }else{
            List<Object> errorList = new ArrayList<>();
            errorList.add("Update request is invalid!!!");
            response.setError(errorList);
        }

        return null;

    }

    public CommonResponse updateMenuById(RequestMenuItem menuItem, String id){
        return null;
    }
}
