package com.example.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controllers.admin.base.BaseAdminController;
import com.example.demo.controllers.admin.base.BaseAdminLinkedController;
import com.example.demo.controllers.utils.UriUtils;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.entities.utils.EntitiesMapping;

@Controller
@RequestMapping(value = {UriUtils.URI_SLASH + BaseAdminController.BASE_ADMIN_CONTROLLER_NAME + UriUtils.URI_SLASH + RoleControllerAdmin.ROLE_CONTROLLER_ADMIN_NAME})
public class RoleControllerAdmin extends BaseAdminLinkedController<Role> {

    public static final String ROLE_CONTROLLER_ADMIN_NAME = "role";
    
    protected RoleControllerAdmin() {
        super(ROLE_CONTROLLER_ADMIN_NAME, Role.class);
    }

    @Override
    public Boolean checkEquality(Role item, Long externalId, String linkedItem) {
        Boolean result = null;
        
        switch (linkedItem) {
        case EntitiesMapping.USER_TO_ROLE:
            for (User user : item.getUsers()) {
                if (user.getId().equals(externalId)) {
                    result = true;
                    break;
                }
            }
            break;

        default:
            break;
        }
        
        return result;
    }
}
