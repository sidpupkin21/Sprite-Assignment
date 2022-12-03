/*************************************************************************************
* CST 8218_302
* Professor: Yamen Nasrallah 
* Author: Ahmed Mohamed
* ID: 041019389
* Last Edited 13/11/2022
* Description: This class established the main Facade used javaBeans stateless components
* Class: SpriteFacade{}
* Method: getEntityManager(), spriteFacade()
*************************************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.moha0901.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tgk
 */
@Stateless
public class SpriteFacade extends AbstractFacade<Sprite> {
    @PersistenceContext(unitName = "SpriteAhmed-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpriteFacade() {
        super(Sprite.class);
    }
    
}
