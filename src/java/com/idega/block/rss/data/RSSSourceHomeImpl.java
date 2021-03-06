/*
 * $Id: RSSSourceHomeImpl.java,v 1.8 2007/02/04 20:42:27 valdas Exp $
 * Created on Feb 27, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.rss.data;

import java.util.Collection;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;


/**
 * 
 *  Last modified: $Date: 2007/02/04 20:42:27 $ by $Author: valdas $
 * 
 * @author <a href="mailto:eiki@idega.com">eiki</a>
 * @version $Revision: 1.8 $
 */
public class RSSSourceHomeImpl extends IDOFactory implements RSSSourceHome {

	private static final long serialVersionUID = 547667038290513507L;

	protected Class getEntityInterfaceClass() {
		return RSSSource.class;
	}

	public RSSSource create() throws javax.ejb.CreateException {
		return (RSSSource) super.createIDO();
	}

	public RSSSource findByPrimaryKey(Object pk) throws javax.ejb.FinderException {
		return (RSSSource) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findSources() throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		java.util.Collection ids = ((RSSSourceBMPBean) entity).ejbFindSources();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public RSSSource findSourceByName(String name) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((RSSSourceBMPBean) entity).ejbFindSourceByName(name);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public RSSSource findSourceByURL(String url) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((RSSSourceBMPBean) entity).ejbFindSourceByURL(url);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public RSSSource findSourceByLocalSourceURI(String uri) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((RSSSourceBMPBean) entity).ejbFindSourceByLocalSourceURI(uri);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public RSSSource findSourceById(int id) throws FinderException {
		com.idega.data.IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((RSSSourceBMPBean) entity).ejbFindSourceById(id);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}
}
