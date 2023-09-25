#include <iostream>
#include <time.h>
#include <vector>

using namespace std;

//1er cas
//int main()
//{
//    int aleatoire=0;
//    int taille;
//    int valCherchee=1;
//    srand(time(NULL));
//
//    cout<<"Encodez la taille du tableau: ";
//    cin>>taille;
//
//    int* tab=new int[taille];
//
//    for(auto i=0;i<taille;i++)
//    {
//        tab[i]=rand()%10 + 1;
//    }
//    cout<<endl;
//
//    for(int i=0;i<taille;i++)
//    {
//        cout<<tab[i]<<"\t";
//    }
//    cout<<endl;
//
//    int indice=0;
//    while(valCherchee!=0)
//    {
//        cout<<"Encodez le nombre à chercher (0 pour terminer):";
//        cin>>valCherchee;
//        if(valCherchee==0)
//        {
//            break;
//        }
//        for(indice=0;indice<taille;indice++)
//        {
//            if(tab[indice]==valCherchee)
//            {
//                cout<<"Le nombre occupe la place "<<indice+1<<"."<<endl;
//            }
//        }
//    }
//
//    delete[] tab;
//}

// 2EME CAS
//int main()
//{
//    int aleatoire=0;
//    int taille;
//    srand(time(NULL));
//
//    cout<<"vector<int> Encodez la taille du tableau: ";
//    cin>>taille;
//
//    std::vector<int> valeurs; //AUCUNE ALLOCATION DYNAMIQUE (Pas de new et de delete)
//
//    for(auto i=0;i<taille;i++)
//    {
//        valeurs.push_back(rand()%10 + 1);
//    }
//    cout<<endl;
//
//    for(int i=0;i<taille;i++)
//    {
//        cout<<valeurs[i]<<"\t";
//    }
//    cout<<endl;
//
//    int indice=0;
//    int valCherchee = 1;
//    while(valCherchee!=0)
//    {
//        cout<<"Encodez le nombre à chercher (0 pour terminer):";
//        cin>>valCherchee;
//        if(valCherchee==0)
//        {
//            break;
//        }
//        for(indice=0;indice<taille;indice++)
//        {
//            if(valeurs[indice]==valCherchee)
//            {
//                cout<<"Le nombre occupe la place "<<indice+1<<"."<<endl;
//            }
//        }
//    }
//}

// 3EME CAS
int main()
{
    int aleatoire=0;
    int taille;
    srand(time(NULL));

    cout<<"vector<int>* Encodez la taille du tableau: ";
    cin>>taille;

    vector<int>* pvecteur = new vector<int>();

    for(auto i=0;i<taille;i++)
    {
        pvecteur->push_back(rand()%10 + 1);
    }
    cout<<endl;

    for(int i=0;i<pvecteur->size;i++)
    {
        cout<<pvecteur[i]<<"\t";
    }
    cout<<endl;

    int indice=0;
    int valCherchee = 1;
    while(valCherchee!=0)
    {
        cout<<"Encodez le nombre à chercher (0 pour terminer):";
        cin>>valCherchee;
        if(valCherchee==0)
        {
            break;
        }
        for(indice=0;indice<taille;indice++)
        {
            if(pvecteur[indice]==valCherchee)
            {
                cout<<"Le nombre occupe la place "<<indice+1<<"."<<endl;
            }
        }
    }
}
