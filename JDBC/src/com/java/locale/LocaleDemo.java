package com.java.locale;
/*
 * 1.getAvailableLocales()
 * 2.getDefault()
 * 3.setDefault()
 * 4.getCountry()
 * 5.getDisplayCountry()
 * 6.getLanguage()
 * 7.getDisplayLanguage()
 * 8.getVariant()
 * 9.getDisplayVariant()
 * 

 */
import java.util.Locale;

public class LocaleDemo {

	public static void main(String[] args) {
    Locale[] locales = Locale.getAvailableLocales();
    System.out.println(locales.length);
    //for(Locale a:locales) {
    //	System.out.println(a +": "+a.getDisplayName());
    // }
    System.out.println(Locale.getDefault());
    Locale.setDefault(new Locale("en","US"));   
    System.out.println(Locale.getDefault());
    Locale l=new Locale("en");
    System.out.println(l.getLanguage());
    //Locale Format or Variant
    //Language(code)+"_"+Country(code)+"_"+(Variant +"_#"|"#")+Script+"-"+Extension
    //Different ways to create Locale Objects .
    
    // 1.using Constructor.
    //2.using forLanguageTag():
     
    Locale languageTag = Locale.forLanguageTag("hi");
    // 3.using builder()
    Locale build = new Locale.Builder().setLanguage("hi").build();
    // 4.
    Locale canada = Locale.CANADA;
    
	}

}
