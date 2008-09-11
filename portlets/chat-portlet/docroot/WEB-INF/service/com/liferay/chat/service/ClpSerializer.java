/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.chat.service;

import com.liferay.chat.model.EntryClp;
import com.liferay.chat.model.StatusClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpSerializer {
	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel oldModel) {
		Class oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(EntryClp.class.getName())) {
			EntryClp oldCplModel = (EntryClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class newModelClass = Class.forName("com.liferay.chat.model.impl.EntryImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setEntryId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getEntryId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCreateDate",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCreateDate());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setFromUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getFromUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setToUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getToUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setContent",
							new Class[] { String.class });

					String value4 = oldCplModel.getContent();

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(StatusClp.class.getName())) {
			StatusClp oldCplModel = (StatusClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class newModelClass = Class.forName("com.liferay.chat.model.impl.StatusImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setStatusId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getStatusId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getModifiedDate());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setActiveBrowserKey",
							new Class[] { String.class });

					String value3 = oldCplModel.getActiveBrowserKey();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List oldList) {
		List newList = new ArrayList(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateInput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel oldModel) {
		Class oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.liferay.chat.model.impl.EntryImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					EntryClp newModel = new EntryClp();

					Method method0 = oldModelClass.getMethod("getEntryId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setEntryId(value0.longValue());

					Method method1 = oldModelClass.getMethod("getCreateDate");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value1.longValue());

					Method method2 = oldModelClass.getMethod("getFromUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setFromUserId(value2.longValue());

					Method method3 = oldModelClass.getMethod("getToUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setToUserId(value3.longValue());

					Method method4 = oldModelClass.getMethod("getContent");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setContent(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("com.liferay.chat.model.impl.StatusImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					StatusClp newModel = new StatusClp();

					Method method0 = oldModelClass.getMethod("getStatusId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setStatusId(value0.longValue());

					Method method1 = oldModelClass.getMethod("getUserId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setUserId(value1.longValue());

					Method method2 = oldModelClass.getMethod("getModifiedDate");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value2.longValue());

					Method method3 = oldModelClass.getMethod(
							"getActiveBrowserKey");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setActiveBrowserKey(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List oldList) {
		List newList = new ArrayList(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateOutput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}