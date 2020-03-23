# language: pt
Funcionalidade: Cálculo de preços e prazos de entrega
  Como usuário do sistema
  Eu quero consultar as informações sobre prazo e custo de uma entrega
  Para que eu possa decidir qual a melhor forma de envio de um produto

  Cenario: Cálculo de preço e prazo de entrega com dados válidos
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "34006-056" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar "Dia da Postagem + 7 dias úteis" no campo Prazo de entrega
    E deveria visualizar "R$ 53,30" no campo Valor total

  Cenario: Cálculo de preço e prazo de entrega com dados válidos
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "34006-056" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar "Dia da Postagem + 7 dias úteis" no campo Prazo de entrega
    E deveria visualizar "R$ 53,30" no campo Valor total
    Dado que acesso a página de cálculo de preços e prazos de entrega dos correios
    Quando digito "10101010" no campo CEP de origem
    E digito "04711-130" campo CEP de destino
    E seleciono "SEDEX" no campo Tipo do serviço
    E seleciono "Caixa / pacote" no campo Formato
    E seleciono "Outra Embalagem" no campo Embalagem
    E digito "9" no campo Altura (cm)
    E digito "18" no campo Largura (cm)
    E digito "27" no campo Comprimento (cm)
    E seleciono "2" no campo Peso estimado (Kg)
    E seleciono " Mão própria" no campo Serviços opcionais
    Quando clico no botao Calcular
    Então deveria ser aberta uma nova aba com Resultado do Cálculo
    E deveria visualizar amensagen de alerta "CEP de origem não encontrado na base de dados dos Correios (-1)."
