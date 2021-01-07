import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestSearch {

	private static int[] readTests(String[] args, int numTests) {
		int[] tests = new int[numTests];
		int value;

		if (args.length == 0)
			for (int i = 0; i < numTests; ++i)
				tests[i] = i + 1;
		else
			for (int i = 0; i < args.length; ++i) {
				value = Integer.parseInt(args[i]);
				if (value >= 1 && value <= numTests)
					tests[value - 1] = value;
				else
					System.out.println("ERROR: Test " + value + "does not exist");
			}
		return tests;
	}

	public static void main(String[] args) throws Exception {
		boolean testPassed;
		//int[] tests = readTests(args, 9);
		int[] tests = {1,2,3,4,5,6,7,8,9};

		String[] param = { "xmap1.txt", "5" }; // Name starts with x to avoid displaying map
		String correct;

		System.out.println("\nTESTS FOR CLASS StartSearch");
		System.out.println("==============================\n");

		if (tests[0] == 1) {

			StartSearch.main(param);
			correct = "push0push2push3push5push6push9pop9pop6pop5pop3pop2pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================");
				System.out.println("TEST 1 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================");
				System.out.println("TEST 1 FAILED");
				System.out.println("==============================\n");
				
			} //end else
				

		} // end if
		
		param[0] = "xmap2.txt";
		param[1] = "8";

		if (tests[1] == 2) {

			StartSearch.main(param);
			correct = "push0push8push3push4push5push10push14push19push24pop24pop19pop14pop10pop5pop4pop3pop8pop0";
			
			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 2 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 2 FAILED");
				System.out.println("==============================\n");
				
			} //end else
		} // end if
		
		param[0] = "xmap3.txt";
		param[1] = "22";

		if (tests[2] == 3) {

			StartSearch.main(param);
			correct = "push0push1push2push3push8push13push18push23push22push21push20push19push14push9push4push5push6push7push12push17push16push15push10pop10pop15pop16pop17pop12pop7pop6pop5pop4pop9pop14pop19pop20pop21pop22pop23pop18pop13pop8pop3pop2pop1pop0";
			
			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 3 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 3 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if
		
		String[] param2 = { "xmap4.txt" };

		if (tests[3] == 4) {

			StartSearch.main(param2);
			correct = "push0push6push11push18push25push32pop32push24pop24pop25push17pop17pop18pop11pop6push5push4push3push2push1push7push12push19push20push13push8pop8pop13push21push22push15pop15pop22pop21push27push34push40push41push35push36push37push38push31pop31push43pop43pop38pop37pop36pop35pop41push39pop39pop40pop34pop27pop20pop19pop12pop7pop1pop2push9push14pop14pop9pop3pop4pop5pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 4 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 4 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if
		
		param[0] = "xmap5.txt";
		param[1] = "250";

		if (tests[4] == 5) {

			StartSearch.main(param);
			correct = "push0push47push38pop38push48push49pop49push61pop61push39push28push17push18push9push10push11push19push30push31pop31push41push50push62push63push64push52push43push32push20push21push12pop12pop21pop20pop32pop43pop52push65pop65pop64pop63pop62push51pop51pop50pop41pop30pop19pop11pop10push8push7push6push16push27push26push15pop15push25push36push46push45push35push24push14pop14pop24push34push33push22push13pop13pop22pop33pop34pop35pop45pop46pop36pop25pop26push37pop37pop27pop16push5push4push3push2push1pop1pop2pop3pop4pop5pop6pop7pop8pop9push29pop29pop18pop17pop28pop39pop48pop47push60push70push77push86push87push88push98push99push100push101pop101push110push111push112pop112pop111pop110pop100pop99pop98push78pop78push89push90push91pop91pop90pop89pop88pop87push97push108push109pop109push107push106push96push95push85push84push83push94push105push104push93push82push76pop76pop82pop93push115push116pop116push125push139push150push151push152push153push142push128push117pop117pop128pop142pop153pop152pop151pop150pop139pop125pop115pop104pop105pop94pop83pop84pop85pop95pop96pop106pop107push119push131push145push155push156push157push147push133push134push135push136push137push138push149push162push161pop161pop162pop149pop138pop137pop136pop135pop134pop133pop147pop157pop156pop155pop145pop131pop119pop108pop97pop86pop77pop70pop60pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 5 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 5 FAILED");
				System.out.println("==============================\n");
				
			} //end else
			
		} // end if
		
		param[0] = "xmap6.txt";
		param[1] = "7";

		if (tests[5] == 6) {

			StartSearch.main(param);
			correct = "push0push1push2push3push6push7push8push5pop5pop8pop7pop6pop3pop2pop1pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 6 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 6 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if
		
		param[0] = "xmap7.txt";
		param[1] = "10";

		if (tests[6] == 7) {

			StartSearch.main(param);
			correct = "push0push1push2push4push9push10push11pop11pop10push8push7pop7pop8pop9pop4pop2pop1pop0";
			
			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 7 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 7 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if
		
		param[0] = "xmap8.txt";

		if (tests[7] == 8) {

			StartSearch.main(param);
			correct = "push0pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 8 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 8 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if
		
		param[0] = "xmap9.txt";

		if (tests[8] == 9) {

			StartSearch.main(param);
			correct = "push0pop0";

			if (ArrayStack.sequence.equals(correct)) {

				testPassed = true;

			} // end if

			else {

				System.out.println("SequenceL: " + ArrayStack.sequence.length() + ", CorrectL: " + correct.length());
				System.out.println(ArrayStack.sequence);
				testPassed = false;

			} // end else

			if (testPassed) {
				
				System.out.println("==============================\n");
				System.out.println("TEST 9 PASSED");
				System.out.println("==============================\n");
				
			} //end if

			else {
				
				System.out.println("==============================\n");
				System.out.println("TEST 9 FAILED");
				System.out.println("==============================\n");
				
			} //end else

		} // end if

		System.exit(0);

	} // end main

} // end TestSearch (class)