/*
 * The contents of this file are subject to the SpotLink Public License,
 * version 1.0 (the “License”); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.thistech.com/spotlink/spl.
 *
 * Software distributed under the License is distributed on an “AS IS”
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is SpotLink Server Code, release date February 14, 2011
 * The Initial Developer of the Original Code is This Technology, LLC.
 * Copyright (C) 2010-2011, This Technology, LLC
 * All Rights Reserved.
 */

package com.thistech.spotlink.persistence;

import com.thistech.spotlink.SpotLinkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author <a href="mailto:matt@thistech.com">Matt Narrell</a>
 *         Created on: 5/12/11
 */
public class TrackingEventsDaoFactory {
    private static final Logger log = LoggerFactory.getLogger(TrackingEventsDaoFactory.class);
    public TrackingEventsDao newInstance(Properties properties) {
        String className = properties.getProperty("trackingEventsDao");
        try {
            @SuppressWarnings("unchecked")
            Class<TrackingEventsDao> clazz = (Class<TrackingEventsDao>) Class.forName(className);
            return clazz.newInstance();
        }
        catch (Exception e) {
            log.error(String.format("Could not construct instance of %s", className));
            throw new SpotLinkException(e);
        }
    }
}
