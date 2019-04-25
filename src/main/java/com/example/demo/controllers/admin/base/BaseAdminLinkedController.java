package com.example.demo.controllers.admin.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controllers.utils.MappedRoutes;
import com.example.demo.controllers.utils.UriUtils;
import com.example.demo.database.base.DbEntity;
import com.example.demo.utils.DumpFields;

public abstract class BaseAdminLinkedController<T extends DbEntity> extends BaseAdminController<T> implements LinkedCrudController<T> {
    
    protected BaseAdminLinkedController(String controllerName, Class klazz) {
        super(controllerName, klazz);
        
        String basePath = UriUtils.URI_SLASH + BaseAdminController.BASE_ADMIN_CONTROLLER_NAME +
                UriUtils.URI_SLASH + controllerName;
        List<String> test = MappedRoutes.getInstance().getRoutes().get(klazz);
        MappedRoutes.getInstance().getRoutes().get(klazz).add(
                basePath + UriUtils.URI_EXTERNAL_INDEX_PATH);
    }

    @Override
    @RequestMapping(value = {UriUtils.URI_EXTERNAL_INDEX_PATH}, method = RequestMethod.GET)
    public String index(Model model, @PathVariable @NotNull Long id, @PathVariable @NotNull String navigationPath) {
        model.addAttribute("view_name", this.controllerName + " filtered index");
        ArrayList<Map<String, Object>> datas = DumpFields.listFielder(super.repository.findAll().stream()
            .filter((T) -> checkEquality(T, id, navigationPath))
                .collect(Collectors.toList()));
        model.addAttribute("items", datas);
        return UriUtils.URI_SLASH + this.controllerName + UriUtils.URI_INDEX_PATH;
    }
    
    public abstract Boolean checkEquality(T item, Long externalId, String linkedItem);
}
