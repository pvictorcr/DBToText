package pvctr.grupoa.dbtotext.utils;

import pvctr.grupoa.dbtotext.fields.NumberField;

public class Utilities {

	public static String treatCPF(String cpfread) {

		if(cpfread != null) {
			cpfread = cpfread.replaceAll("\\D+", ""); //remove tudo que nao for numero

			if(cpfread == null || cpfread.equals(""))
				cpfread = "00000000000";

			String cpf = cpfread.substring(0, 3) + "." + cpfread.substring(3, 6) + "." + cpfread.substring(6, 9) + "-" + cpfread.substring(9, 11);

			return cpf;
		}

		return "11111111111111";
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

public static String treatSimounao(String simounaoread) {

	switch (simounaoread) {
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
public static String treatCtpsdv(String ctpsdvread) {

	if(ctpsdvread == null) {

	return "";
}
	return ctpsdvread;
}
public static String treatTipoInsc(String tipoinscread) {

	switch (tipoinscread) {
	
	case "1":
		return "02";
	case "2":
		return "03";
	
	}

	return "02";
}
public static String treatTiposdeAfastamento(String tiposdeafastamentoread) {

	switch (tiposdeafastamentoread) {
	
	case "01":
		return "02";
	case "02":
		return "13";
	case "03":
		return "03";
	case "04":
		return "04";
	case "05":
		return "05";	
	case "06":
		return "08";
	case "07":
		return "35";
	case "08":
		return "06";
	case "09":
		return "25";
	case "10":
		return "26";
	case "11":
		return "27";
	case "12":
		return "24";
	case "13":
		return "23";
	case "14":
		return "14";
	case "15":
		return "15";
	case "16":
		return "08";
	case "17":
		return "22";
	case "18":
		return "22";
	case "19":
		return "22";
	case "20":
		return "22";
	case "21":
		return "22";
	case "22":
		return "24";
	case "23":
		return "22";
	case "24":
		return "22";
	case "25":
		return "28";
	case "26":
		return "04";
	case "27":
		return "31";
	
	}

	return "03";
}

public static String treatTipoaviso(String tipoavisoread) {

	switch (tipoavisoread) {
	case "I":
		return "1";
	case "T":
		return "0";
	}

	return "0";
}


public static String getCnpjComVerificador(String cnpjSemVerificador) {

	cnpjSemVerificador = cnpjSemVerificador.replaceAll("\\D", "");
	
	int[] pesos1 = {5,4,3,2,9,8,7,6,5,4,3,2};
	int[] pesos2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
	
	int acumulado = 0;
	for(int i = 0; i < cnpjSemVerificador.length(); i++) {
		acumulado += (Integer.parseInt(cnpjSemVerificador.charAt(i)+"")) * pesos1[i];
	}

	int digito = acumulado % 11 < 2 ? 0 : 11 - (acumulado%11);
	
	cnpjSemVerificador += digito;
	
	acumulado = 0;
	for(int i = 0; i < cnpjSemVerificador.length(); i++) {
		acumulado += (Integer.parseInt(cnpjSemVerificador.charAt(i)+"")) * pesos2[i];
	}

	digito = acumulado % 11 < 2 ? 0 : 11 - (acumulado%11);
	
	return cnpjSemVerificador + digito;
}


public static String treatTipoaviso2(String tipoaviso2read) {

	switch (tipoaviso2read) {
	case "T":
		return "1";
	case "I":
		return "2";
	}

	return "3";
}




public static String treatTlicodigo(String tlicodigoread) {
switch (tlicodigoread) {

case "12":
	return "1";
case "13":
	return "1";

}

return "0";
}

public static String treatInsalubridade(String insalubridaderead) {
switch (insalubridaderead) {

case "016":
	return insalubridaderead;
case "100":
	return insalubridaderead;
case "212":
	return insalubridaderead;
case "905":
	return insalubridaderead;	

}

return "0";
}



public static String treatPericulosidade(String periculosidaderead) {
switch (periculosidaderead) {

case "013":
	return periculosidaderead;
case "930":
	return periculosidaderead;
}

return "0";
}

public static String treatInfprovdesc(String infprovdescread) {

	switch (infprovdescread) {
	case "0":
		return "I";
	case "1":
		return "P";
	case "2":
		return "D";
	}   return infprovdescread;
} 
}
