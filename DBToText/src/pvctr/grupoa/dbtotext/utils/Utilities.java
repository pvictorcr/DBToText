package pvctr.grupoa.dbtotext.utils;

public class Utilities {

	public static String treatCPF(String cpfread) {

		if(cpfread != null) {
			cpfread = cpfread.replaceAll("\\D+", ""); //remove tudo que nao for numero

			if(cpfread == null || cpfread.equals(""))
				cpfread = "00000000000";

			String cpf = cpfread.substring(0, 3) + "." + cpfread.substring(3, 6) + "." + cpfread.substring(6, 9) + "-" + cpfread.substring(9, 11);

			return cpf;
		}

		return "00000000000000";
	}

	public static String treatCEP(String cepread) {

		if(cepread != null) {
			cepread = cepread.replaceAll("\\D+", ""); //remove tudo que nao for numero

			if(cepread == null || cepread.equals("") || cepread.length() < 8)
				cepread = "00000000";

			String cep = cepread.substring(0, 2) + "." + cepread.substring(2, 5) + "-" + cepread.substring(5, 8);

			return cep;
		}

		return "";
	}

	public static int toNumbersOnly(String mixedSymbols) {

		if(mixedSymbols != null) {
			String tmp = mixedSymbols.replaceAll("\\D+", ""); //remove tudo o que nao for numero da string

			if(tmp == null || tmp.equals(""))
				return 0;

			return Integer.parseInt(tmp);
		}

		return 0;
	}

	public static int treatSex(String sexoread) {

		if(sexoread != null) {
			if(sexoread.trim().equals("M") || sexoread.trim().equals("m"))
				return 1;
			else if(sexoread.trim().equals("F") || sexoread.trim().equals("f"))
				return 2;
		}

		return 0;
	}

	
	
	public static int treatRacaCor(int racacorread) {

		switch (racacorread) {
		case 1:
			return 2;
		case 2:
			return 4;
		case 3:
			return 6;
		case 4:
			return 8;
		case 5:
			return 1;	
		case 6:
			return 9;
		}

		return 9;
	}
	public static int treatEstadoCivil(int estadocivilread) {
		
		switch (estadocivilread) {
		case 1:
			return 1;
		case 2:
			return 7;
		case 3:
			return 9;
		case 4:
			return 8;
		case 5:
			return 4;
		case 6:
			return 3;
		case 7:
			return 3;
		case 8:
			return 7;
		case 9:
			return 2;
		case 10:
			return 5;
			
		}
		return 0;
	}
	
	
	public static int getCodmunicipio(String siglaestado, String codMunRaes) {

		if(siglaestado == null)
			siglaestado = "";
		if(codMunRaes == null)
			codMunRaes = "";
		
		return MunicipioUtilities.getCodmunicipioRaes(siglaestado, codMunRaes);
	}
	
	public static long getCodFuncionario(String s_codEmpresa, String s_codPessoa) {
		
		int codEmpresa = 0;
		int codPessoa = 0;
		
		if(s_codEmpresa != null && s_codEmpresa.trim().matches("\\d+"))
			codEmpresa = Integer.parseInt(s_codEmpresa);
			
		if(s_codPessoa != null && s_codPessoa.trim().matches("\\d+"))
			codPessoa = Integer.parseInt(s_codPessoa);
		
		return codEmpresa*1000000 + codPessoa;
	}
	

public static int treatCodigotipocontr(int codigotipocontrread) {

	switch (codigotipocontrread) {
	case 101:
		return 1;
	case 722:
		return 2;
	}

	return 1;
}

public static String treatFgts(String fgtsread) {

	switch (fgtsread) {
	case "N":
		return "0";
	case "S":
		return "1";
	}

	return "1";
}

public static String treatCNPJ(String cnpjread) {

	if(cnpjread != null) {
		cnpjread = cnpjread.replaceAll("\\D+", ""); //remove tudo que nao for numero

		if(cnpjread == null || cnpjread.equals(""))
			cnpjread = "00000000000000";

		String cnpj = cnpjread.substring(0, 2) + "." + cnpjread.substring(2, 5) + "." + cnpjread.substring(5, 8) + "/" + cnpjread.substring(8, 12) + "-" + cnpjread.substring(12, 14);

		return "";
	}

	return "";
}

public static String treatParente(String parenteread) {

	switch (parenteread) {
	
	case "01":
		return "02";
	case "02":
		return "16";
	case "03":
		return "01";
	case "04":
		return "12";
	case "05":
		return "03";	
	case "06":
		return "21";
	case "07":
		return "13";
	case "08":
		return "17";
	case "15":
		return "22";
	case "99":
		return "14";
	}

	return "14";
}

public static String treatIncapaztrabalhar(String incapaztrabalharread) {

	switch (incapaztrabalharread) {
	case "N":
		return "0";
	case "S":
		return "1";
	}

	return "0";
}
public static String treatUfsigla(String ufsiglaread) {

	if(ufsiglaread == null) {

		if(ufsiglaread == null || ufsiglaread.equals(""))
			ufsiglaread = "RN";

	return ufsiglaread;
}
	return ufsiglaread;
}
}