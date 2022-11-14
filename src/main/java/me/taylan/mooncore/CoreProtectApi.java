package me.taylan.mooncore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import net.coreprotect.CoreProtect;

// --Commented out by Inspection START (14.11.2022 02:08):
//public class CoreProtectApi {
//	private final MoonCore plugin;
//
//// --Commented out by Inspection START (14.11.2022 02:08):
////	public CoreProtectApi(MoonCore plugin) {
////		this.plugin = plugin;
////	}
//// --Commented out by Inspection STOP (14.11.2022 02:08)
//
//	public static net.coreprotect.CoreProtectAPI getCoreProtect() {
//		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("CoreProtect");
//
//		// Check that CoreProtect is loaded
//		if (plugin == null || !(plugin instanceof CoreProtect)) {
//			return null;
//		}
//
//		// Check that the API is enabled
//		net.coreprotect.CoreProtectAPI CoreProtect = ((CoreProtect) plugin).getAPI();
//		if (CoreProtect.isEnabled() == false) {
//			return null;
//		}
//
//		// Check that a compatible version of the API is loaded
//		if (CoreProtect.APIVersion() < 7) {
//			return null;
//		}
//
//		return CoreProtect;
//	}
//}
// --Commented out by Inspection STOP (14.11.2022 02:08)
