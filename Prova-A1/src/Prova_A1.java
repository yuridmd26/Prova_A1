import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Prova_A1 
{

	public static void main(String[] args) 
	{
		final char REGRA_LETRA_A = 'A';
		final char REGRA_LETRA_M = 'M';
		final char REGRA_LETRA_Y = 'Y';
		final char REGRA_LETRA_U = 'U';
		final char REGRA_LETRA_R = 'R';
		final char REGRA_LETRA_I = 'I';
		
		char cOpcaoParaNovaOp;
		int iQtdUsuariosLidos        = 0;
		int iQtdBeneficiarios        = 0;
		int iQtdTempoBeneficioMaior  = 0;
		int iQtdTempoBeneficioMaior2 = 0;

		double dValorTotalBeneficios = 0.0;
		double dValorMaior           = 0.0;
		double dValorMaior2          = 0.0;
		
		String sBeneficiarioMaiorValor1 = "";
		String sBeneficiarioMaiorValor2 = "";
		
		String sBeneficiarioMaiorTempo1 = "";
		String sBeneficiarioMaiorTempo2 = "";
		
		do
		{
			
		iQtdUsuariosLidos++;
			
		Scanner sc = new Scanner(System.in);
		
		sc.reset();
		String sNomeCompleto;
		System.out.println("Informe seu nome completo: ");
		sNomeCompleto = sc.nextLine();

		String sDataNasc;
		System.out.println("Informe sua data de nascimento: ");
		sDataNasc = sc.next();
		
		System.out.println("==========CATEGORIAS============");
		System.out.println("= 1- Empregado                 =");
		System.out.println("= 2- Empregador                =");
		System.out.println("= 3- Desempregado              =");
		System.out.println("================================");
		
		int iCategoria = 0;
		System.out.println("\n Informe sua categoria (por numeros de acordo com a tabela): ");
		
		do
		{
			iCategoria = sc.nextInt();
		
			if (iCategoria < 1 || iCategoria > 3)
			{
				System.out.println("Numero de categora invalida, informe novamente de acordo com a tabela: ");
			}
		
		} while (iCategoria < 1 || iCategoria > 3);
	
		int iQtdFuncionarios      = 0;
		int iQtdMesesDesempregado = 0;
		
		String sCategoria = "";
		double dSalario = 0.0;
		
		Boolean EhAposentado = false;
		
		switch(iCategoria)
		{
			case 1:
			{
				sCategoria = "Empregado";
				char cOpcao;
				
				System.out.println("Você é aposentado? ((S) - Sim / (N) - Não)");
				
				do
				{
					cOpcao = sc.next().charAt(0);
					
					if (cOpcao != 'S' && cOpcao != 'N' && cOpcao != 's' && cOpcao != 'n')
					{
						System.out.println("Opção utilizada invalida, por favor utilize (S) para Sim, ou (N) para Não: ");
					}
					
				} while (cOpcao != 'S' && cOpcao != 'N' && cOpcao != 's' && cOpcao != 'n');
				
				System.out.println("Informe o valor do beneficio: ");
				
				sc.reset();
				
				do
				{
					dSalario = sc.nextDouble();
					
					if (dSalario < 1000.00 || dSalario > 1800.00)
					{	
						System.out.println("O Salário de beneficio é entre R$1000.00 e R$1800.00, informe seu salario novamente: ");
					}
					
				} while (dSalario < 1000.00 || dSalario > 1800.00);
				
				break;
			}
			
			case 2:
			{
				sCategoria = "Empregador";
				
				System.out.println("Informe quantos funcionarios voce tem: ");
				do
				{
					iQtdFuncionarios = sc.nextInt();
					
					if (iQtdFuncionarios <= 0)
					{
						System.out.println("Você precisa ter uma quantidade de funcionarios superior a 1");
					}
					
				} while (iQtdFuncionarios <= 0);
				
				dSalario = 200.00 * iQtdFuncionarios;
				
				break;
			}
			
			case 3:
			{
				System.out.println("Informe quantos meses voce esta desempregado: ");
				do 
				{
					iQtdMesesDesempregado = sc.nextInt();

					if (iQtdMesesDesempregado <= 0)
					{
						System.out.println("A quantidade de meses desempregados precisa ser positiva");
					}

				} while(iQtdMesesDesempregado <= 0);
				
				System.out.println("Informe o valor do beneficio: ");
				
				do
				{
					dSalario = sc.nextDouble();
					
					if (dSalario < 1500.00 || dSalario > 2300.00)
					{	
						System.out.println("O Salário de beneficio é entre R$1500.00 e R$2300.00, informe seu salario novamente: ");
					}
					
				} while (dSalario < 1500.00 || dSalario > 2300.00);
				break;
			}
		}
		
		sc.reset();
		
		String sEstado;
		System.out.println("Informe o seu estado: ");
		sc.nextLine();
		sEstado = sc.nextLine();
		
		int iQtdTempoBeneficio = 0;
		
		LocalDate dataAtual = LocalDate.now();
		LocalDate data = LocalDate.parse(sDataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		int idade = dataAtual.getYear() - data.getYear();
		
		if (dataAtual.getMonthValue() == data.getMonthValue())
		{
			if (dataAtual.getDayOfMonth() < data.getDayOfMonth())
			{
				idade -= 1;
			}
		}
		else
		{
			if (dataAtual.getMonthValue() < data.getMonthValue())
			{
				idade -= 1;
			}
		}
		
		String sRegras = "";
		
		//Regra de négocios é Y u r i M a
		
		if (idade >= 18)
		{
			sRegras = sRegras + "I";
			
			if (idade > 50 && sCategoria == "Empregado")
			{
				iQtdTempoBeneficio = 5;
				sRegras = sRegras + "Y";
			}
			else if (sCategoria == "Empregado")
			{
				iQtdTempoBeneficio = 3;
				sRegras = sRegras + "U";
			}
		
			if (iQtdFuncionarios <= 10 && sCategoria == "Empregador")
			{
				iQtdTempoBeneficio = 10;
				sRegras = sRegras + "R";
			}
		
			if (sEstado.toUpperCase().equals("SAO PAULO"))
			{
				dSalario += dSalario * 0.10;
				sRegras = sRegras + "M";
			}
			
		}
		else
		{
			sRegras = "A";
		}
		
		System.out.println("==========FICHA CADASTRAL======================");
		System.out.println("= Nome: " + sNomeCompleto);
		System.out.println("= Data de Nasicmento: " + sDataNasc);
		System.out.println("= Categoria: " + sCategoria);
		System.out.println("= As regras utilizadas foram: ");
		
		if (sRegras.length() != 0 && sRegras.charAt(0) != REGRA_LETRA_A)
		{
			iQtdBeneficiarios++;
		}
		
		for (int i = 0; i < sRegras.length(); ++i)
		{
			switch(sRegras.charAt(i))
			{
				case REGRA_LETRA_A:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_A + ": O benefício só será concedido para maiores de 18 anos");
					break;
				}
				case REGRA_LETRA_M:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_M + ": O benefício de pessoas que moram em São Paulo terá acréscimo de 10%");
					break;
				}
				case REGRA_LETRA_Y:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_Y + ": O Benefício será de 5 meses para empregados com mais de 50 anos");
					break;
				}
				case REGRA_LETRA_U:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_U + ": O Benefício será de 3 meses para empregados");
					break;
				}
				case REGRA_LETRA_R:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_R + ": O Benefício será de 10 meses para empregadores com até 10 funcionários");
					break;
				}
				case REGRA_LETRA_I:
				{
					System.out.println((i + 1) + "- " + REGRA_LETRA_I + ": Sábado deve ser considerado dia útil para pagamento");
					break;
				}
				default:
				{
					System.out.println(i + "- Nao foi utilizada nenhuma regra.");
				}
			}
		}
		
		if (iQtdTempoBeneficio == 0)
		{
			iQtdTempoBeneficio = 2;
		}
		
		System.out.println("= Tempo de beneficio: " + iQtdTempoBeneficio);
		System.out.println("= Valor do beneficio: " + dSalario);
		System.out.println("===========================================");
		
		System.out.println("Deseja ler um novo beneficiario? (S) para Sim / (N) para Não");
		cOpcaoParaNovaOp = sc.next().charAt(0);
		
		if (sRegras.length() != 0 && sRegras.charAt(0) != REGRA_LETRA_A)
		{
			dValorTotalBeneficios += dSalario * iQtdTempoBeneficio;
		}
		
		if (dSalario > dValorMaior)
		{
			if (dValorMaior == 0)
			{
				dValorMaior = dSalario;
				sBeneficiarioMaiorValor1 = sNomeCompleto;
			}
			else
			{
				dValorMaior2 = dSalario;
				sBeneficiarioMaiorValor2 = sNomeCompleto;
			}
			
		}
		else if (dSalario > dValorMaior2)
		{
			dValorMaior2 = dSalario;
			sBeneficiarioMaiorValor2 = sNomeCompleto;
		}
		
		if (dValorMaior < dValorMaior2)
		{
			double aux   = dValorMaior;
			dValorMaior  = dValorMaior2;
			dValorMaior2 = aux;
			
			String sAux              = sBeneficiarioMaiorValor1;
			sBeneficiarioMaiorTempo1 = sBeneficiarioMaiorValor2;
			sBeneficiarioMaiorTempo2 = sAux;
		}
		
		if (iQtdTempoBeneficio > 0 && iQtdTempoBeneficio > iQtdTempoBeneficioMaior)
		{
			if (iQtdTempoBeneficioMaior == 0)
			{
				iQtdTempoBeneficioMaior = iQtdTempoBeneficio;
				sBeneficiarioMaiorTempo1 = sNomeCompleto;
			}
			else
			{
				iQtdTempoBeneficioMaior2 = iQtdTempoBeneficio;
				sBeneficiarioMaiorTempo2 = sNomeCompleto;
			}
		}
		else if (iQtdTempoBeneficio > 0 && iQtdTempoBeneficio > iQtdTempoBeneficioMaior2)
		{
			iQtdTempoBeneficioMaior2 = iQtdTempoBeneficio;
			sBeneficiarioMaiorTempo2 = sNomeCompleto;
		}
		
		if (iQtdTempoBeneficioMaior < iQtdTempoBeneficioMaior2)
		{
			int aux                  = iQtdTempoBeneficioMaior;
			iQtdTempoBeneficioMaior  = iQtdTempoBeneficioMaior2;
			iQtdTempoBeneficioMaior2 = aux;
			
			String sAux              = sBeneficiarioMaiorTempo1;
			sBeneficiarioMaiorTempo1 = sBeneficiarioMaiorTempo2;
			sBeneficiarioMaiorTempo2 = sAux;
		}
		
		if (cOpcaoParaNovaOp == 'N' || cOpcaoParaNovaOp == 'n')
		{
			sc.close();
		}
		
		} while (cOpcaoParaNovaOp != 'N' && cOpcaoParaNovaOp != 'n');
		
		System.out.println("=====================FINAL============================");
		System.out.println("= Total de usuarios lidos: " + iQtdUsuariosLidos);
		System.out.println("= Total beneficiarios: " + iQtdBeneficiarios);
		System.out.println("= Total de valor concedido: " + dValorTotalBeneficios);
		System.out.println("= 1- Beneficiario de maior valor: " + sBeneficiarioMaiorValor1 + " R$: " + dValorMaior );
		System.out.println("= 2- Beneficiario de maior valor: " + sBeneficiarioMaiorValor2 + " R$: " + dValorMaior2);
		System.out.println("= 1- Beneficiario de maior tempo: " + sBeneficiarioMaiorTempo1 + " Tempo: " + iQtdTempoBeneficioMaior);
		System.out.println("= 2- Beneficiario de maior tempo: " + sBeneficiarioMaiorTempo2 + " Tempo: " + iQtdTempoBeneficioMaior2);
		System.out.println("======================================================");
	}
}

//Prova feita pelo o aluno Yuri Daniel Martins Defreyn.
