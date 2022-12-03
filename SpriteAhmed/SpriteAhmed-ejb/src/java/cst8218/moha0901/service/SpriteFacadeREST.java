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
* Description: This class manages the RESTFUL API configuration. 
*              It will define a getter for EntityManager.
*              It contains methods to preform GET,POST,DELETE,PUT operations
*              
* Class: SpriteFacadeREST{}
* Method: SpriteFacadeREST(), create(), edit(), remove(), find(), findAll(), 
*         findRange(), countREST(), getEntityManager()
*************************************************************************************/
package cst8218.moha0901.service;

import cst8218.moha0901.entity.Sprite;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;

/**
 *
 * @author sid
 * 
 */
@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "${'java:comp/DefaultDataSource'}",
    callerQuery = "#{'select password from app.Appuser where username = ?'}",
    groupsQuery = "select groupname from app.Appuser where username = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 10
)
//@RolesAllowed({"Admin","RestG"})
//@DeclareRoles({"Admin","RestG"})
@javax.ejb.Stateless
@javax.ws.rs.Path("cst8218.moha0901.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteAhmed-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    @javax.ws.rs.POST
    @Override
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }

    @javax.ws.rs.PUT
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public void edit(@javax.ws.rs.PathParam("id") Long id, Sprite entity) {
        super.edit(entity);
    }

    @javax.ws.rs.DELETE
    @javax.ws.rs.Path("{id}")
    public void remove(@javax.ws.rs.PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @javax.ws.rs.GET
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Sprite find(@javax.ws.rs.PathParam("id") Long id) {
        return super.find(id);
    }


    @javax.ws.rs.GET
    @Override
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    @javax.ws.rs.GET
    @javax.ws.rs.Path("{from}/{to}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@javax.ws.rs.PathParam("from") Integer from, @javax.ws.rs.PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @javax.ws.rs.GET
    @javax.ws.rs.Path("count")
    @javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
