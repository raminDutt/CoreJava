package coreJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import annotationProcessor.JavaDocProcessor.Param;

public class DataOutputStreamCh11Q2 {

	Path path = null;

	public DataOutputStreamCh11Q2(Path path) {

		this.path = path;
	}

	private static abstract class Entity {
		public String type;
		public String name;
		public String value = null;

		public abstract String toString();

	}

	private static class PrimitiveEntity extends Entity {

		@Override
		public String toString() {
			String res = "{type=" + type + ", name=" + name + ", value="
					+ value + "}";
			return res;
		}

	}

	private static class CompositeEntity extends Entity {
		public List<Entity> fields = new ArrayList<>();

		@Override
		public String toString() {
			return fields
					.stream()
					.map(field -> field.toString())
					.collect(
							Collectors.joining(",", "{type=" + type + ", name="
									+ name + ", value=" + value + ", fields={",
									"}}"));

		}

		@Param(name="field", description="Field of Entity")
		public void addField(Entity field) {
			fields.add(field);
		}
	}

	private boolean isPrimitive(String type) {

		boolean isPrimitive = false;
		switch (type) {
		case "boolean":
			isPrimitive = true;
			break;
		case "byte":
			isPrimitive = true;
			break;
		case "short":
			isPrimitive = true;
			break;
		case "int":
			isPrimitive = true;
			break;
		case "long":
			isPrimitive = true;
			break;
		case "float":
			isPrimitive = true;
			break;
		case "double":
			isPrimitive = true;
			break;
		case "char":
			isPrimitive = true;
			break;
		case "java.lang.String":
			isPrimitive = true;
			break;
		default:
			isPrimitive = false;
		}
		return isPrimitive;
	}

	private <T> T getDefault(Class<?> componentType) {
		T result = null;
		Object array = Array.newInstance(componentType, 1);
		result = (T) Array.get(array, 0);
		T[] array2 = (T[]) array;
		return result;
	}

	private String getPrimitiveValue(String type, Field field, Object obj) {

		field.setAccessible(true);
		String result = null;

		try {
			if (type.equals("boolean")) {
				boolean value = (obj != null) ? field.getBoolean(obj)
						: getDefault(boolean.class);
				result = Boolean.valueOf(value).toString();
				return result;
			}
			if (type.equals("byte")) {
				byte value = (obj != null) ? field.getByte(obj)
						: getDefault(byte.class);
				result = Byte.valueOf(value).toString();
				return result;
			}
			if (type.equals("short")) {
				short value = (obj != null) ? field.getShort(obj)
						: getDefault(short.class);
				result = Short.valueOf(value).toString();
				return result;
			}
			if (type.equals("int")) {
				int value = (obj != null) ? field.getInt(obj)
						: getDefault(int.class);
				result = Integer.valueOf(value).toString();
				return result;
			}
			if (type.equals("long")) {
				long value = (obj != null) ? field.getLong(obj)
						: getDefault(long.class);
				result = Long.valueOf(value).toString();
				return result;
			}
			if (type.equals("float")) {
				float value = (obj != null) ? field.getFloat(obj)
						: getDefault(float.class);
				result = Float.valueOf(value).toString();
				return result;
			}
			if (type.equals("double")) {

				double value = (obj != null) ? field.getDouble(obj)
						: getDefault(double.class);
				result = Double.valueOf(value).toString();
				return result;
			}
			if (type.equals("char")) {
				char value = (obj != null) ? field.getChar(obj)
						: getDefault(char.class);
				result = Character.valueOf(value).toString();
				return result;
			}

			if (type.equals("java.lang.String")) {
				result = (obj != null) ? (String) field.get(obj) : null;
				return result;
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void setPrimitiveValue(String type, Field field, Object obj,
			String value) {
		Objects.requireNonNull(obj);
		field.setAccessible(true);
		try {
			if (type.equals("boolean")) {
				field.setBoolean(obj, Boolean.valueOf(value));
			}
			if (type.equals("byte")) {
				field.setByte(obj, Byte.valueOf(value));
			}
			if (type.equals("short")) {
				field.setShort(obj, Short.valueOf(value));
			}
			if (type.equals("int")) {
				field.setInt(obj, Integer.valueOf(value));
			}
			if (type.equals("long")) {
				field.setLong(obj, Long.valueOf(value));
			}
			if (type.equals("float")) {
				field.setFloat(obj, Float.valueOf(value));
			}
			if (type.equals("double")) {
				field.setDouble(obj, Double.valueOf(value));
			}
			if (type.equals("char")) {
				field.setChar(obj, value.toCharArray()[0]);
			}
			if (type.equals("java.lang.String")) {
				field.set(obj, value);
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private Entity constructEntity(Object object) throws Exception {
		Class<? extends Object> objectClass = object.getClass();
		

		Entity entity = null;
		if (isSerializable(objectClass)) {
			if (objectClass.isPrimitive()) {

				// TODO
				Exception exception = new Exception(objectClass.getSimpleName()
						+ ": is primitive. This is not supported yet");
				throw exception;
			}
			
			if(objectClass.isArray())
			{
				//TODO
				
			}
			else {

				
				CompositeEntity compositeEntity = new CompositeEntity();
				compositeEntity.type = objectClass.getTypeName();
				compositeEntity.name = "root";
				compositeEntity.value = new Integer(object.hashCode())
						.toString();
				Field[] fields = objectClass.getDeclaredFields();
				for (Field field : fields) {
					if (!isTransient(field)) {
						Entity e = constructField(field, object);
						if (e != null) {
							compositeEntity.addField(e);
						}
					}

				}
				entity = compositeEntity;
			}

		} else {
			Exception exception = new Exception(objectClass.getSimpleName()
					+ ": is not annotated with @Serializable");
			throw exception;

		}
		return entity;
	}

	/**
	 * ch11Q4
	 * 
	 * @param field
	 * @return
	 */
	private boolean isTransient(Field field) {
		Class<? extends Annotation> annotationClass = Transient.class;
		return field.isAnnotationPresent(annotationClass);

	}
	
	private boolean isSerializable(Class<?> obj) {
		Class<? extends Annotation> annotationClass = Serializable.class;
		return obj.isAnnotationPresent(annotationClass);
	}

	private Entity constructField(Field field, Object objectTarget) {

		Entity entity = null;

		Class<?> fieldClass = field.getType();

		if (fieldClass.isPrimitive()
				|| fieldClass.getTypeName().equals("java.lang.String")) {
			PrimitiveEntity primitiveEntity = new PrimitiveEntity();
			primitiveEntity.type = fieldClass.getTypeName();
			primitiveEntity.name = field.getName();
			primitiveEntity.value = getPrimitiveValue(primitiveEntity.type,
					field, objectTarget);
			entity = primitiveEntity;

		} else {
			// If field is not annotated with @Serializable then skip. We only
			// Serialize primitive values and serializable objects
			if (isSerializable(fieldClass)) {
				CompositeEntity compositeEntity = new CompositeEntity();

				compositeEntity.type = fieldClass.getName();
				compositeEntity.name = field.getName();
				try {
					objectTarget = field.get(objectTarget);
					if (objectTarget == null) {
						compositeEntity.value = null;
						return compositeEntity;
					} else {
						compositeEntity.value = Integer.valueOf(
								objectTarget.hashCode()).toString();
					}

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

				Field[] fields = fieldClass.getDeclaredFields();
				Entity fieldEntity = null;
				for (Field f : fields) {

					// Only serialize non transient fields
					if (!isTransient(f)) {
						fieldEntity = constructField(f, objectTarget);

						if (fieldEntity != null) {
							compositeEntity.addField(fieldEntity);
						}
					}

				}
				entity = compositeEntity;

			}

		}

		return entity;

	}



	public Object readObject() {
		Object object = null;
		try (InputStream inputStream = new FileInputStream(path.toFile());
				ObjectInputStream objectInputStream = new ObjectInputStream(
						inputStream);) {

			String objectString = (String) objectInputStream.readObject();
			System.out.println(objectString);
			object = constructEntity(objectString);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return object;
	}

	Object constructEntity(String serialzedObject) {
		Object entity = null;
		// Extract Attributes of the serialized objects
		String regex = "^\\{(type=(.*?)), (name=(.*?)), (value=(.*?)),?\\s?(fields=\\{(.*)\\})?\\}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(serialzedObject);

		if (matcher.matches()) {
			String type = matcher.group(2);
			String name = matcher.group(4);
			String value = matcher.group(6);
			String field = matcher.group(8);

			try {
				if (isPrimitive(type)) {
					return null;
				}

				Class<?> typeClass = Class.forName(type);
				entity = typeClass.newInstance();

				Field[] fields = typeClass.getDeclaredFields();
				Map<String, Map<String, Field>> map = new HashMap<>();
				for (Field f : fields) {
					Map<String, Field> map2 = new HashMap<>();
					map2.put(f.getType().getName(), f);
					map.put(f.getName(), map2);
				}

				// Extracting Fields from the serialized object
				List<String> serializedFields = extractFields(field);
				for (String serializedField : serializedFields) {
					Matcher fieldMatcher = pattern.matcher(serializedField);
					if (fieldMatcher.matches()) {
						String fieldType = fieldMatcher.group(2);
						String fieldName = fieldMatcher.group(4);
						String fieldValue = fieldMatcher.group(6);
						String subField = fieldMatcher.group(8);

						Field field2 = map.get(fieldName).get(fieldType);

						if (isPrimitive(fieldType)) {
							setPrimitiveValue(fieldType, field2, entity,
									fieldValue);

						} else {
							field2.setAccessible(true);
							if (fieldValue.equals("null")) {
								field2.set(entity, null);
							} else {
								Object entityField = constructEntity(serializedField);

								field2.set(entity, entityField);
							}

						}

					}

				}

			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				e.printStackTrace();
			}

		}

		return entity;
	}

	private List<String> extractFields(String field) {
		Stack<String> stack = new Stack<String>();
		int length = field.length();
		int startIndex = 0;
		int lastIndex = 0;

		List<String> fields = new ArrayList<String>();

		char openBrace = '{';
		char closedBrace = '}';

		int i = 0;
		while (i < length) {
			if (field.charAt(i) == openBrace) {

				if (stack.isEmpty()) {
					startIndex = i;
				}
				stack.push(Character.toString(openBrace));

			}
			if (field.charAt(i) == closedBrace) {
				stack.pop();
				if (stack.isEmpty()) {
					lastIndex = i;
					String subField = field
							.substring(startIndex, lastIndex + 1);
					fields.add(subField);
				}
			}
			i++;
		}

		return fields;
	}

	/**
	 * object must not be primitive but contain primitive or non-primitive
	 * instance variable Serializes object if is annotated with @Serializable.
	 * Serializes the field of objects that are primitive values. Serializes
	 * field of objects that are serializable (annotated with @Serializable)
	 * Serializes final instance variables but the value will not be restored
	 * since during creation, the constructor of object will be called and the
	 * final value will be set during initialization and therefore could not be
	 * overwritten with serialized value. Does not serialize field of object
	 * that are arrays
	 * 
	 * @param object
	 */
	public void writeObject(Object object) {
		System.out.println("Serialzing: Started ....");

		Entity entity;
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				path.toFile());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(
						fileOutputStream);) {
			entity = constructEntity(object);
			String entityString = entity.toString();
			System.out.println(entityString);
			objectOutputStream.writeObject(entityString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Serialzing: Completed  --> " + path.toString());

	}

}
