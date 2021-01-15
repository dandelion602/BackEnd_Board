<template>
  <div class="q-pa-md">


     <div class="row justify-center">

      <div class="col-12 col-md-auto">
         <form @submit.prevent="register">
        <label for="name">
          Name:
        </label>
        <input v-model="name" type="text" name="name" value>

        <label for="email">
          Email:
        </label>
        <input v-model="email" type="email" name="email" value>

        <label for="password">
          Password:
        </label>
        <input v-model="password" type="password" name value>



        <button type="submit" name="button">
          Register
        </button>
         </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    
}
</script>

<style lang="scss" scoped>
    .q-pa-md{
        padding: 15px 40%;
        max-width: 50%;
        height: 100vhs;
        display: flex;
        
        .q-input{
          max-width: 600px;
        }
    }
    .title{
      text-align: center;
    }
</style>