/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*************************************************************************************
* CST 8218_302
* Professor: Yamen Nasrallah 
* Author: Ahmed Mohamed
* ID: 041019389
* Last Edited 13/11/2022
* Description:
* Class: ApplicationConfig{}
* Method: getClasses(), addRestResourceClasses()
*************************************************************************************/
package cst8218.moha0901.service;

import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 *
 * @author sid
 */
@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "${'java:comp/DefaultDataSource'}",
    callerQuery = "#{'select password from app.appuser where username = ?'}",
    groupsQuery = "select groupname from app.appuser where username = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 10
)
@Named
@BasicAuthenticationMechanismDefinition
@RolesAllowed({"Admin","JsfGroup"})
@DeclareRoles({"Admin","JsfGroup"})
@ApplicationScoped
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cst8218.moha0901.service.SpriteFacadeREST.class);
        resources.add(app.AppuserFacade.class);
        resources.add(cst8218.moha0901.entity.SpriteFacade.class);
    }
    
}
