class aula8 {
	static void test () { 
		
		String nullString = null;
		String emptyString = "";
		String s1 = "Olá mundo";
		String s4 = String.valueOf (42);
		String s5 = String.valueOf ('Z');
		String s6 = String.valueOf (3.14);
		String s7 = String.valueOf (true);

		int length = s1.length();
		char c = s1.charAt (2);
		
		char [] word = s1.toCharArray();
		String s3 = new String (word);
		
		ColorImage img = new ColorImage(200, 150);
		img.drawText(30, 50, "And the answer is ..", 20, new Color(255,255,255));
		img.drawCenteredText(100, 100, s4, 30, new Color(0,255,0));
		
		Color c1 = Color.RED;
		Color c2 = c1.inverse();
		Color c3 = c2.brighter(-80);
		Color c4 = c3.grayEquivalent();
		boolean b1 = c4.isEqualTo(c3);
		 Color[] v  = { Color.RED, new Color(220, 220, 220), Color.BLUE };
		 boolean b2 = c1.containedIn(v);
	 
		 ColorImage img2 = new ColorImage("coffee.jpg");
		// ColorImage img4 = img2.copy();
		 ColorImage img5 = img2.blackWhite();
		 // img2.light(100);
		 img2.mirror();
		
		 
		

		return;
	}
}
	