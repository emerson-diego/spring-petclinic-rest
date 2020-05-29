/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.alura.forum.controller;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.alura.forum.modelo.Owner;
import br.com.alura.forum.modelo.Pet;
import br.com.alura.forum.modelo.PetType;
import br.com.alura.forum.modelo.Visit;

/**
 * @author Vitaliy Fedoriv
 *
 */

public class JacksonCustomVisitSerializer extends StdSerializer<Visit> {

    public JacksonCustomVisitSerializer() {
        this(null);
    }

    protected JacksonCustomVisitSerializer(Class<Visit> t) {
        super(t);
    }

    @Override
    public void serialize(Visit visit, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if ((visit == null) || (visit.getPet() == null)) {
            throw new IOException("Cannot serialize Visit object - visit or visit.pet is null");
        }
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        jgen.writeStartObject(); // visit
        if (visit.getId() == null) {
            jgen.writeNullField("id");
        } else {
            jgen.writeNumberField("id", visit.getId());
        }
        jgen.writeStringField("date", formatter.format(visit.getDate()));
        jgen.writeStringField("description", visit.getDescription());

        Pet pet = visit.getPet();
        jgen.writeObjectFieldStart("pet");
        if (pet.getId() == null) {
            jgen.writeNullField("id");
        } else {
            jgen.writeNumberField("id", pet.getId());
        }
        jgen.writeStringField("name", pet.getName());
        jgen.writeStringField("birthDate", formatter.format(pet.getBirthDate()));

        PetType petType = pet.getType();
        jgen.writeObjectFieldStart("type");
        if (petType.getId() == null) {
            jgen.writeNullField("id");
        } else {
            jgen.writeNumberField("id", petType.getId());
        }
        jgen.writeStringField("name", petType.getName());
        jgen.writeEndObject(); // type

        Owner owner = pet.getOwner();
        jgen.writeObjectFieldStart("owner");
        if (owner.getId() == null) {
            jgen.writeNullField("id");
        } else {
            jgen.writeNumberField("id", owner.getId());
        }
        jgen.writeStringField("firstName", owner.getFirstName());
        jgen.writeStringField("lastName", owner.getLastName());
        jgen.writeStringField("address", owner.getAddress());
        jgen.writeStringField("city", owner.getCity());
        jgen.writeStringField("telephone", owner.getTelephone());
        jgen.writeEndObject(); // owner
        jgen.writeEndObject(); // pet
        jgen.writeEndObject(); // visit
    }

}
