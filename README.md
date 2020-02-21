## Share your Experiences
Desarrollo de una aplicación para dar feed a experiencias personales en sus viajes por el Perú 

> Clean Architecture with Kotlin

**Capa de Presentación**

En la capa de presentación, se hace uso del Patrón **MVVM** para permitir los cambios de datos de manera reactiva.
Así mismo se usa el patron Factory para poder pasarle parametros al ViewModel

Elementos:
- Entidades de la capa Presentación
- ViewModel
- ViewModelFactory
- Mappers


**Capa de Datos**

En la capa de datos hacemos uso de Firebase para extraer y registrar datos tanto del usuario como así sus experiencias.
Elementos:
- Entidades de la capa Datos
- Implementación de los interactors dependientes del origen de datos
- Mappers


**Capa de Dominio**
- Entidades de la capa Dominio
- Interactors o UsesCases


# Dependencias:
1. Glide
2. Material Design
3. LifeCycle - LiveData
4. Coroutinas
5. Firebase Database
6. Firebase Auth
7. Firebase FireStore
