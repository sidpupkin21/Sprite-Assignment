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
* Interface: SpriteSessionRemote{}
*************************************************************************************/
package cst8218.moha0901.game;
import cst8218.moha0901.entity.Sprite;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author tgk
 */
@Remote
public interface SpriteSessionRemote {
    	List<Sprite> getSpriteList() throws RemoteException;
	void newSprite(MouseEvent e) throws RemoteException;
	int getHeight() throws RemoteException;
	int getWidth() throws RemoteException;
}
