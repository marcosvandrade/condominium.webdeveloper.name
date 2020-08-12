import { http } from '../plugins/axios'

export default {

    salvar:(usuario) => {
        return http.post('admin/cadastro', usuario);
    },

    deletar:(usuario) => {
      return http.delete('admin/{id}', usuario )  
    },

    listar:(usuario) => {
        return http.get('admin/usuarios', usuario);
    },

    atualizar:(usuario) => {
        return http.put(usuario)
    }

}
