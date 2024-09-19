# 1. Introdução

O problema da Mochila é um dos mais famosos problemas da área de Otimização Combinatória (ficando atrás apenas do Problema do Caixeiro viajante, talvez). Trata-se de um problema com diversas aplicações, variações e extensões.

O desafio em resolver tal problema é que trata-se de um problema NP-Difícil, ou seja, o custo computacional de resolver uma instância cresce exponencialmente com o tamanho do problema. Nessas situações, uma alternativa frequente é utilizar abordagens heurísticas.

No contexto de problemas de Otimização, uma heurística é uma abordagem com elementos intuitivos que encontra uma boa solução (não necessariamente uma solução ótima), mas em um tempo computacional reduzido (polinomial). Neste trabalho, é pedido que você implemente uma das heurísticas mais famosas para o problema da mochila. Tanto a heurística quanto o problema são definidos a seguir.

# 2. O problema da Mochila

Considere uma mochila com capacidade C>0 e n tipos de itens. Cada tipo de item é definido pelo seu peso (wi>0), pela sua utilidade ui>0 e pelo número de itens disponíveis daquele tipo di>0. Determine a quantidade de cada tipo de item a ser colocada na mochila de forma a maximizar a utilidade carregada, sem extrapolar a capacidade da mochila.

Encontrar uma solução ótima para tal problema requer algoritmos relativamente sofisticados. Portanto, neste trabalho, vamos utilizar uma heurística gulosa.

# 3. A heurística gulosa

Uma das heurísticas mais famosas para o problema da mochila consiste em ordenar de forma decrescente o conjunto de tipos de itens utilizando a medida uiwi. Considere que, após a ordenação, os tipos de itens são numerados 0,…,n−1. Então, coloca-se na mochila o máximo possível de itens de tipo 1, em seguida, coloca-se o máximo possível de itens do tipo 2 e, assim por diante, até que não haja mais itens disponíveis ou não haja capacidade na mochila. Em caso de empate, coloque o tipo de item de menor índice como anterior na sequência.

## 3.1. Um exemplo

Capacidade da mochila = 20

```
Tipo 0 1 2 3 4 5
ui   18 12 15 10 15 4
wi   5 4 5 2 6 2
di   1 2 3 2 5 5
```

Ordenando os tipos itens em ordem decrescente de ui/wi, tem-se a seguinte ordem (3,0,1,2,4,5). Portanto, a solução dada pela heurística gulosa seria:

```
Tipo Quantidade na mochila
3 2
0 1
1 2
2 0
4 0
5 1
```

Contabilizando uma utilidade total de 66.

# 4. Formatação de entrada e saída

Para sua implementação, considere que os dados são digitados do teclado com o seguinte padrão. Na i-ésima linha há, respectivamente, os valores ui, wi e di. A entrada dos itens termina com uma linha com a cadeia de caracteres "-1 -1 -1", seguida de um único número inteiro com a capacidade da mochila. O exemplo da seção anterior, seria fornecido como:

> 18 5 1
>
> 12 4 2
>
> 15 5 3
>
> 10 2 2
>
> 15 6 5
>
> 4 2 5
>
> -1 -1 -1
>
> 20

Como resposta, a implementação deve fornecer a quantidade de cada tipo de item que foi adicionado na mochila, um por linha, na ordem definida pela heurística. Então, para o exemplo fornecido, tem-se:

> 3 2
>
> 0 1
>
> 1 2
>
> 5 1

Assuma que serão fornecidos apenas valores inteiros.

# 5. Informações importantes

- O algoritmo de ordenação deve ser implementado pelo estudante (não serão aceitas solução que utilizam as funções de ordenação prontas da linguagem, como o sort do Python).
- Para a leitura dos dados, em C++, você pode adaptar o seguinte trecho de código (que apenas imprime os dados fornecidos):

```c++
int x, y, z;
std::cin >> x >> y >> z;
while (x != -1) {
    std::cout << x << ' ' << y << ' ' << z << '\n';
    std::cin >> x >> y >> z;
}
int cap;
std::cin >> cap;
```
