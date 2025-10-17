package me.tehpicix.rusherhack.autorename;

import java.lang.reflect.Field;
import java.util.Arrays;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;

public class AnvilScreenAccessInvoker {
	public static EditBox getEditBox(AnvilScreen screen) {
		System.out.println("Fields: " + Arrays.toString(screen.getClass().getDeclaredFields()));
		try {
			Field field = screen.getClass().getDeclaredField("field_2821");
			field.setAccessible(true);
			return field.get(screen) instanceof EditBox ? (EditBox)field.get(screen) : null;
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
