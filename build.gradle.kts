/**
 +---------+
 | Plugins |
 +---------+
 */
plugins {
    alias(ihub.plugins.root)
    alias(ihub.plugins.copyright)
}
//subprojects {
//	apply {
//		plugin 'pub.ihub.plugin.ihub-native'
//	}
//	iHubBom {

//		importBoms {
//			group 'pub.ihub.lib' module 'ihub-libs' version 'main-SNAPSHOT'
//		}
//	}
//}
