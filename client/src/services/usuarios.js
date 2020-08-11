import { http } from '../plugins/axios'

export default {

    salvar:(usuario) => {
        return http.post('admin/cadastro', usuario);
    },

    deletar:(id) => {
      return http.delete('admin/{id}', id)  
    },

    listar:(usuario) => {
        return http.get('admin/usuarios', usuario);
    },

    atualizar:(usuario) => {
        return http.put(usuario)
    }

}
