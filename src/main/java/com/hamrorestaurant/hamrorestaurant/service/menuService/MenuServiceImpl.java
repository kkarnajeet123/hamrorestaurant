package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.model.menu.RequestMenuItem;
import com.hamrorestaurant.hamrorestaurant.repository.MenuItemRepository;
import com.hamrorestaurant.hamrorestaurant.util.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.util.Constants;
import com.hamrorestaurant.hamrorestaurant.web.rest.error.CommonApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.xml.bind.DataBindingException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    protected static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MenuItemRepository menuRepo;

    @Override
    public CommonResponse saveMenuItem(RequestMenuItem menuItem) {
        CommonResponse response = new CommonResponse();

        if (!ObjectUtils.isEmpty(menuItem) && !StringUtils.isEmpty(menuItem.getItemName())) {
            MenuItemPrice  items = menuRepo.findByItemName(menuItem.getItemName());
            if (ObjectUtils.isEmpty(items)) {
                MenuItemPrice newMenuItem = new MenuItemPrice();
                newMenuItem.setMenuItem(menuItem.getMenuName());
                newMenuItem.setItemName(menuItem.getItemName());
                newMenuItem.setPrice(menuItem.getPrice());
                newMenuItem.setCategory(menuItem.getCategory());
                newMenuItem.setDescription(menuItem.getItemDescription());
                menuRepo.save(newMenuItem);

                response.setData("Data has been saved !!");
                return response;
            } else {
                List<Object> errorList = new
                        ArrayList<>();
                errorList.add("Unable to save records, some problem occured while saving in DB ");
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new
                    ArrayList<>();
            errorList.add("Item already available !!!");
            response.setError(errorList);
        }
        return response;
    }

    public CommonResponse updateMenuByName(RequestMenuItem menuItem, String name) {
        CommonResponse response = new CommonResponse();
        MenuItemPrice menuItemPrice = new MenuItemPrice();
        if (!ObjectUtils.isEmpty(menuItem) && !StringUtils.isEmpty(menuItem.getItemName()) && !StringUtils.isEmpty(name)) {
            MenuItemPrice menu = menuRepo.findByItemName(name);
            if (!ObjectUtils.isEmpty(menu)) {
                menuItemPrice.setId(menu.getId());
                menuItemPrice.setItemName(menuItem.getItemName());
                menuItemPrice.setMenuItem(menuItem.getMenuName());
                menuItemPrice.setPrice(menuItem.getPrice());
                menuItemPrice.setCategory(menuItem.getCategory());
                //saving menu item object
                menuRepo.save(menuItemPrice);
                response.setData("Record has been updated!!!");
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Item not available!!!");
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("Update request is invalid!!!");
            response.setError(errorList);
        }
        return response;
    }

    public CommonResponse updateMenuById(RequestMenuItem menuItem, String id) {
        CommonResponse response = new CommonResponse();
        MenuItemPrice menuItemPrice = new MenuItemPrice();
        if (!ObjectUtils.isEmpty(menuItem) && !StringUtils.isEmpty(menuItem.getItemName()) && !StringUtils.isEmpty(id)) {
            MenuItemPrice menu = menuRepo.findById(Long.parseLong(id)).orElse(null);
            if (!ObjectUtils.isEmpty(menu)) {
                menuItemPrice.setId(menu.getId());
                menuItemPrice.setItemName(menuItem.getItemName());
                menuItemPrice.setMenuItem(menuItem.getMenuName());
                menuItemPrice.setPrice(menuItem.getPrice());
                menuItemPrice.setCategory(menuItem.getCategory());
                //saving menu item object
                menuRepo.save(menuItemPrice);
                response.setData("Record has been updated!!!");
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Item not available!!!");
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("Update request is invalid!!!");
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse deleteMenuById(String id) {
        CommonResponse response = new CommonResponse();
        if (!StringUtils.isEmpty(id)) {
            MenuItemPrice menu = menuRepo.findById(Long.parseLong(id)).orElse(null);
            if (!ObjectUtils.isEmpty(menu)) {
                menuRepo.delete(menu);
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("No menu records found with the Id ".concat(id) + " please try again");
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("Id is not valid!!! Please check the menu id ".concat(id) + " please try again");
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse deleteMenuByName(String name) {
        CommonResponse response = new CommonResponse();
        if (!StringUtils.isEmpty(name)) {
            MenuItemPrice menu = menuRepo.findByItemName(name);
            try {
                if (!ObjectUtils.isEmpty(menu)) {
                    menuRepo.delete(menu);
                }
            } catch (Exception e) {
                throw new CommonApplicationException(Constants.Err_1, Constants.ErrorDescription_1, e);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("Name is not valid!!! Please check the menu name ".concat(name) + " please try again");
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse getAllMenu() {
        CommonResponse response = new CommonResponse();
        try {
            List<MenuItemPrice> menuItemPrice = menuRepo.findAll();
            response.setData(menuItemPrice);
        } catch (DataBindingException e) {
            throw new CommonApplicationException(Constants.Err_1, Constants.ErrorDescription_1, e);
        }
        return response;
    }

    @Override
    public CommonResponse getAllDrinks() {
        CommonResponse response = new CommonResponse();
        try {
            List<MenuItemPrice> menuItemPrice = menuRepo.findAll();
//            List<String> drinkListById = menuItemPrice.stream().filter(menu -> menu.getCategory().equalsIgnoreCase(Constants.Drinks)).forEach(drinksById->{
//                menuItemPrice.stream().map(m->m.getItemName()).collect(Collectors.toList());
//            });
            List<Long> drinkListById = menuItemPrice.stream().filter(menu -> menu.getCategory().equalsIgnoreCase(Constants.Drinks)).map(m -> m.getId()).collect(Collectors.toList());
            drinkListById.forEach(drinks -> {
                List<String> drinkList = menuItemPrice.stream().map(m -> m.getItemName()).collect(Collectors.toList());
                response.setData(drinkList);
            });
        } catch (DataBindingException e) {
            throw new CommonApplicationException(Constants.Err_1, Constants.ErrorDescription_1, e);
        }
        return response;
    }

    @Override
    public CommonResponse getMenuById(String id) {
        CommonResponse response = new CommonResponse();
        if (!StringUtils.isEmpty(id)) {
            MenuItemPrice menuItemPrice = menuRepo.findById(Long.parseLong(id)).get();
            if (!ObjectUtils.isEmpty(menuItemPrice)) {
                response.setData(menuItemPrice);
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Menu item is not available with the given id: ".concat(id));
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("The provided id is not valid ".concat(id).concat(". please try with different id."));
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse getMenuByName(String name) {
        CommonResponse response = new CommonResponse();
        if (StringUtils.isEmpty(name)) {
            MenuItemPrice menuItemPrice = menuRepo.findByItemName(name);
            if (!ObjectUtils.isEmpty(menuItemPrice)) {
                response.setData(menuItemPrice);
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Menu item is not available with the given name: ".concat(name));
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("The provided id is not valid ".concat(name).concat(". please try with different name."));
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse getDrinksById(String id) {
        CommonResponse response = new CommonResponse();
        if (!StringUtils.isEmpty(id)) {
            MenuItemPrice menuItemPrice = menuRepo.findById(Long.parseLong(id)).get();
            if (!ObjectUtils.isEmpty(menuItemPrice)) {
                response.setData(menuItemPrice);
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Menu item is not available with the given id: ".concat(id));
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("The provided id is not valid ".concat(id).concat(". please try with different id."));
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public CommonResponse getDrinksByName(String name) {
        CommonResponse response = new CommonResponse();
        if (StringUtils.isEmpty(name)) {
            MenuItemPrice menuItemPrice = menuRepo.findByItemName(name);
            if (!ObjectUtils.isEmpty(menuItemPrice)) {
                response.setData(menuItemPrice);
            } else {
                List<Object> errorList = new ArrayList<>();
                errorList.add("Menu item is not available with the given name: ".concat(name));
                response.setError(errorList);
            }
        } else {
            List<Object> errorList = new ArrayList<>();
            errorList.add("The provided id is not valid ".concat(name).concat(". please try with different name."));
            response.setError(errorList);
        }
        return response;
    }
}
