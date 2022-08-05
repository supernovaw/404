class C404 {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.err.println("no argument");
			System.exit(1);
		}
		byte[] secondary = parse(args[0]);
		byte[] input = System.in.readAllBytes();
		xor(input, secondary);
		System.out.write(input);
	}

	private static void xor(byte[] array, byte[] secondary) {
		for (int i = 0; i < array.length; i++) {
			byte b1 = array[i];
			byte b2 = secondary[i % secondary.length];
			array[i] = (byte) (b1 ^ b2);
		}
	}

	private static byte[] parse(String hex) {
		byte[] bs = new byte[hex.length() / 2];
		for (int i = 0; i < bs.length; i++) {
			bs[i] = (byte) (Integer.parseUnsignedInt(hex.substring(i * 2, i * 2 + 2), 16) & 0xff);
		}
		return bs;
	}
}
