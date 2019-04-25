package com.example.demo.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controllers.admin.base.BaseAdminController;
import com.example.demo.controllers.admin.base.BaseAdminLinkedController;
import com.example.demo.controllers.utils.UriUtils;
import com.example.demo.entities.Job;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.entities.utils.EntitiesMapping;

@Controller
@RequestMapping(value = {UriUtils.URI_SLASH + BaseAdminController.BASE_ADMIN_CONTROLLER_NAME + UriUtils.URI_SLASH + JobControllerAdmin.JOB_CONTROLLER_ADMIN_NAME})
public class JobControllerAdmin extends BaseAdminLinkedController<User> {

    public static final String JOB_CONTROLLER_ADMIN_NAME = "job";
    
    protected JobControllerAdmin() {
        super(JOB_CONTROLLER_ADMIN_NAME,Job.class);
    }

    @Override
    public Boolean checkEquality(User item, Long externalId, String linkedItem) {
        Boolean result = null;
        
        switch (linkedItem) {
        case EntitiesMapping.USER_TO_JOB:
            for (Role role : item.getRoles()) {
                if (role.getId().equals(externalId)) {
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
