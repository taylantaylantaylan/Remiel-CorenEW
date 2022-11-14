package me.taylan.mooncore.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Painter {
	public static final Pattern COLOR_PATTERN = Pattern.compile("&(#[a-fA-F0-9]{6})");
	public static final Function<String,ChatColor> COLOR_FUNCTION = ChatColor::of;
	public static String paint(String s) {

		return ChatColor.translateAlternateColorCodes('&', s);
	}

	@Nullable
	@Contract("null -> null; !null -> !null")

	public static String splitCapitalize(@Nullable String str) {
		return splitCapitalize(str,null,'&');
	}


	@Nullable
	@Contract("null,_ -> null; !null,_ -> !null")


	public static String splitCapitalize(@Nullable String str, String splitReg) {
		return splitCapitalize(str,splitReg,'&');
	}

	@Nullable
	@Contract("null,_ -> null; !null,_ -> !null")
	public static String splitCapitalize(@Nullable String str, @Nullable Character colorCode) {

		return splitCapitalize(str,null,colorCode);
	}

	@Nullable
	@Contract("null,_,_ -> null; !null,_,_ -> !null")
	public static String splitCapitalize(@Nullable String str, @Nullable String splitReg, @Nullable Character colorCode) {
		if (str == null) return null;
		String[] splitName;
		if (splitReg == null || splitReg.isEmpty()) splitName = new String[] {str};
		else splitName = str.split(splitReg);
		StringBuilder newStr = new StringBuilder();
		char[] arr;
		char c,d;
		for (String sub : splitName) {
			arr = sub.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				c = arr[i];
				if (colorCode != null && colorCode == c) {
					newStr.append(colorCode);
					if (i < arr.length - 1) {
						d = arr[i + 1];
						if (colors(colorCode,colorCode.toString() + d).charAt(0) != colorCode) {
							newStr.append(d);
							i++;
						}
					}
				} else if (Character.isLetter(c)){
					newStr.append(Character.toUpperCase(c));
					while (++i < arr.length) {
						c = arr[i];
						if (Character.isLetter(c)) newStr.append(Character.toLowerCase(c));
						else {
							newStr.append(c);
							break;
						}
					}
				} else newStr.append(c);
			}
		}
		return newStr.toString();
	}
	@NotNull
	public static String colors(char colorChar,@NotNull String str) {
		return ChatColor.translateAlternateColorCodes(colorChar,matchAndReplace(str,COLOR_PATTERN,COLOR_FUNCTION));
	}
	@NotNull
	public static String matchAndReplace(@NotNull final String str, @NotNull Pattern pattern, @NotNull Function<String,?> replace) {
		int lastIndex = 0;
		StringBuilder output = new StringBuilder();
		Matcher matcher = pattern.matcher(str);
		Object replaced;
		while (matcher.find()) {
			replaced = replace.apply(matcher.group(1));
			if (replaced == null) continue;
			output.append(str,lastIndex,matcher.start()).append(replaced);
			lastIndex = matcher.end();
		}
		if (lastIndex < str.length()) output.append(str,lastIndex,str.length());
		return output.toString();
	}
}
